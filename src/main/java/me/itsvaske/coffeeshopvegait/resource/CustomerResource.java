package me.itsvaske.coffeeshopvegait.resource;

import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Customer;
import me.itsvaske.coffeeshopvegait.model.request.CustomerDTO;
import me.itsvaske.coffeeshopvegait.repo.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerRepository customerRepository;

    public static final String PATH = "/customer";

    @RequestMapping(path = PATH + "/add", method = RequestMethod.POST)
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerDTO customer) {

        var existingCustomer = customerRepository.findByName(customer.getName());

        if(existingCustomer != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var newCustomer = new Customer();

        newCustomer.setName(customer.getName());
        newCustomer.setPassword(customer.getPassword());

        return new ResponseEntity<>(customerRepository.save(newCustomer), HttpStatus.CREATED);
    }
}
