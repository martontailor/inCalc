package com.martontailor.incalc.domain;

import com.martontailor.incalc.domain.type.IncomeType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "INCOMES")
public class Income {

    @Id
    private String id;
    private Double amount;
    private IncomeType type;
    private String description;
    @CreatedDate
    private LocalDateTime localDateTime;

}
