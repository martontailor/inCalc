package com.martontailor.incalc.api;

import com.martontailor.incalc.domain.Income;
import com.martontailor.incalc.repo.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestController {

    private IncomeRepository incomeRepository;

    @Autowired
    public TestController(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @GetMapping("/db")
    public String helloWorld() {
        Income income = new Income();
        income.setAmount(100.0);
        income.setLocalDateTime(LocalDateTime.now());
        incomeRepository.save(income);
        return incomeRepository.findAll().toString();
    }

    @GetMapping("/security")
    public String security(){
        return "Authenticated";
    }


}
