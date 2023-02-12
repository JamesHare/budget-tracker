package com.jameshare.budgettracker.controller;

import com.jameshare.budgettracker.model.Transaction;
import com.jameshare.budgettracker.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping()
    public String showTransactionDashboard(final Model model,
                                           @RequestParam(name = "month") int month,
                                           @RequestParam(name = "year") int year) {
        final List<Transaction> transactions = transactionService.findAllTransactionsByMonthAndYear(month, year);
        model.addAttribute("transactions", transactions);
        return "/statement";
    }



}
