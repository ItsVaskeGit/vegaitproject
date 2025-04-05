package me.itsvaske.coffeeshopvegait.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Barista;
import me.itsvaske.coffeeshopvegait.model.Drink;
import me.itsvaske.coffeeshopvegait.model.Order;
import me.itsvaske.coffeeshopvegait.model.request.OrderDTO;
import me.itsvaske.coffeeshopvegait.repo.DrinkRepository;
import me.itsvaske.coffeeshopvegait.repo.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final DrinkRepository drinkRepository;
    private final EspressoMachineService espressoMachineService;

    @Override
    @Transactional
    public ResponseEntity<Order> placeOrder(OrderDTO order) {

        var coffeeShop = order.getBarman().getCoffeeShop();

        var baristas = coffeeShop.getBaristas();

        var newOrder = new Order();

        var coffeeRequired = 0;

        for(Drink drink : order.getDrinks()) {
            coffeeRequired += drink.getCoffeeRequired();
        }

        for(Barista barista : baristas) {
            var espressoMachine = barista.getEspressoMachine();
            if(espressoMachine.getCoffeeLeft() >= coffeeRequired && espressoMachine.getReady()) {
                newOrder.setBarman(order.getBarman());
                espressoMachine.setCoffeeLeft(espressoMachine.getCoffeeLeft() - coffeeRequired);
            }else if(espressoMachine.getCoffeeLeft() < drinkRepository.findCoffeeWithLeastRequirements() && espressoMachine.getReady()) {
                espressoMachine.setReady(false);
                espressoMachineService.startRefillProcess(espressoMachine.getId());
            }
        }

        if(newOrder.getBarman() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        newOrder.setOrdered(order.getDrinks());
        newOrder.setOrderType(order.getOrderType());
        newOrder.setBarman(order.getBarman());
        newOrder.setCustomer(order.getCustomer());

        return new ResponseEntity<>(repository.save(newOrder), HttpStatus.OK);
    }

}
