package com.berkepite.first.backend.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoDTO {
    private Long id;
    private String text;
    private boolean done;
}
