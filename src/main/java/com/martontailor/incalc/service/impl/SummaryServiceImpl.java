package com.martontailor.incalc.service.impl;

import com.martontailor.incalc.domain.Income;
import com.martontailor.incalc.domain.Outcome;
import com.martontailor.incalc.domain.Summary;
import com.martontailor.incalc.repo.IncomeRepository;
import com.martontailor.incalc.repo.OutcomeRepository;
import com.martontailor.incalc.repo.SummaryRepository;
import com.martontailor.incalc.repo.UserRepository;
import com.martontailor.incalc.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryServiceImpl implements SummaryService {

    private SummaryRepository summaryRepository;
    private UserRepository userRepository;
    private OutcomeRepository outcomeRepository;
    private IncomeRepository incomeRepository;

    @Autowired
    public SummaryServiceImpl(SummaryRepository summaryRepository,
                              UserRepository userRepository,
                              OutcomeRepository outcomeRepository,
                              IncomeRepository incomeRepository) {
        this.summaryRepository = summaryRepository;
        this.userRepository = userRepository;
        this.outcomeRepository = outcomeRepository;
        this.incomeRepository = incomeRepository;
    }

    @Override
    public Summary addIncome(Income income, String username) {
        Summary summary = getSummary(username);
        List<Income> incomes = summary.getIncomes();

        incomeRepository.save(income);

        incomes.add(income);
        summary.setIncomes(incomes);

        return summaryRepository.save(summary);
    }

    @Override
    public Summary addOutCome(Outcome outcome, String username) {
        Summary summary = getSummary(username);
        List<Outcome> outcomes = summary.getOutcomes();

        outcomeRepository.save(outcome);

        outcomes.add(outcome);
        summary.setOutcomes(outcomes);
        return summaryRepository.save(summary);
    }

    @Override
    public Summary getSummary(String username) {
        return userRepository.findByUsername(username).getSummary();
    }

    @Override
    public Double getBalance(String username) {
        Summary summary = getSummary(username);
        return calculateIncomes(summary) - calculateOutcomes(summary);
    }

    private Double calculateIncomes(Summary summary) {
        return summary.getIncomes().stream()
                .map(Income::getAmount)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    private Double calculateOutcomes(Summary summary) {
        return summary.getOutcomes().stream()
                .map(Outcome::getAmount)
                .reduce(Double::sum)
                .orElse(0.0);
    }

}
