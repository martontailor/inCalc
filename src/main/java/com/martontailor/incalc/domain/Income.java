package com.martontailor.incalc.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "INCOMES")
public class Income {

    @Id
    private String id;

    private Double amount;

    private LocalDateTime localDateTime;

}
