package com.martontailor.incalc.api;

import com.martontailor.incalc.domain.Income;
import com.martontailor.incalc.domain.Outcome;
import com.martontailor.incalc.domain.Summary;
import com.martontailor.incalc.service.SummaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SummaryController.class);

    private SummaryService summaryService;

    @Autowired
    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @PostMapping("/income")
    public Summary addIncome(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Income income) {
        return summaryService.addIncome(income, userDetails.getUsername());
    }

    @PostMapping("/outcome")
    public Summary addOutcome(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Outcome outcome) {
        return summaryService.addOutCome(outcome, userDetails.getUsername());
    }

    @GetMapping("/summary")
    public Summary getSummary(@AuthenticationPrincipal UserDetails userDetails) {
        return summaryService.getSummary(userDetails.getUsername());
    }

    @GetMapping("/balance")
    public Double getBalance(@AuthenticationPrincipal UserDetails userDetails) {
        return summaryService.getBalance(userDetails.getUsername());
    }

}
