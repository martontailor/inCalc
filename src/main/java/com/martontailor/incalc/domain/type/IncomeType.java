package com.martontailor.incalc.domain.type;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "INCOME_TYPES")
public enum IncomeType {
    SALARY, SELLING, OTHER
}
