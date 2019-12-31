package com.martontailor.incalc.service;

import com.martontailor.incalc.domain.Income;
import com.martontailor.incalc.domain.Outcome;
import com.martontailor.incalc.domain.Summary;

public interface SummaryService {

    Summary addIncome(Income income, String username);

    Summary addOutCome(Outcome outcome, String username);

    Summary getSummary(String username);

    Double getBalance(String username);

}
