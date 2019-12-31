package com.martontailor.incalc.domain.type;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OUTCOME_TYPES")
public enum OutcomeType {
    TAX, BUYING, OTHER
}
