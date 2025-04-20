package me.itsvaske.coffeeshopvegait;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.itsvaske.coffeeshopvegait.model.request.DrinkDTO;
import me.itsvaske.coffeeshopvegait.service.DrinkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CoffeeActionsTest {

    public static final String URL = "http://localhost:8080/";

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DrinkService drinkService;

    @Test
    @Rollback
    void testAdding() {

        var dto = new DrinkDTO();

        dto.setName("Neka kafa");
        dto.setTimeRequired(200);
        dto.setCoffeeRequired(20);
        dto.setPrice(2);

//        given(drinkService.add(dto)).willReturn(drinkService.getAll().get(1));
    }
}
