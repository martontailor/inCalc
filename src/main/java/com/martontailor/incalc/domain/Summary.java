package com.martontailor.incalc.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "SUMMARIES")
public class Summary {

    @Id
    private String id;
    private Double balance;
    @DBRef
    private List<Income> incomes;
    @DBRef
    private List<Outcome> outcomes;

}
