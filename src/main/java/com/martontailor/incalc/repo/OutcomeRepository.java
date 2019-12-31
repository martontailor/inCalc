package com.martontailor.incalc.repo;

import com.martontailor.incalc.domain.Outcome;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OutcomeRepository extends MongoRepository<Outcome, String> {
}
