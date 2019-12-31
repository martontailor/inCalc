package com.martontailor.inCalc.repo;

import com.martontailor.inCalc.domain.Income;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends MongoRepository<Income, String> {
}
