package me.itsvaske.coffeeshopvegait.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.repo.EspressoMachineRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class EspressoMachineServiceImpl extends ThreadPoolTaskScheduler implements EspressoMachineService {

    private final EspressoMachineRepository repository;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void resetCoffee() {

        if(repository.count() > 0) {
            repository.resetCoffee();
        }

    }

    @Override
    @Transactional
    public void startRefillProcess(Long espressoMachineId) {

        var task = new Runnable() {
            @Override
            public void run() {
                repository.refill(espressoMachineId);
            }
        };

        super.scheduleWithFixedDelay(task, Duration.ofMinutes(2));
    }
}
