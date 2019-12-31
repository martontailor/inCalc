package com.martontailor.incalc.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "OUTCOMES")
public class Outcome {

    @Id
    private String id;
    private Double amount;
    @CreatedDate
    private LocalDateTime localDateTime;
}
