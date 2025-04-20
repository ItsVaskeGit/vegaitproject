package me.itsvaske.coffeeshopvegait.model.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CustomerDTO {

    private String name;

    private String password;
}
