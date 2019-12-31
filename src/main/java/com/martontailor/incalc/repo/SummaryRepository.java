package com.martontailor.incalc.repo;

import com.martontailor.incalc.domain.Summary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SummaryRepository extends MongoRepository<Summary, String> {
}
