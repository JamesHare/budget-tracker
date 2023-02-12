package com.jameshare.budgettracker.controller;

import com.jameshare.budgettracker.model.CategoryTotal;
import com.jameshare.budgettracker.model.Transaction;
import com.jameshare.budgettracker.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("statement")
    public String showStatement(final Model model,
                                @RequestParam(name = "month") int month,
                                @RequestParam(name = "year") int year) {
        final List<Transaction> transactions = transactionService.findAllTransactionsByMonthAndYear(month, year);
        model.addAttribute("transactions", transactions);
        return "/statement";
    }

    @GetMapping("categorize")
    public String showUncategorized(final Model model) {
        final List<Transaction> uncategorizedTransactions = transactionService.findAllByCategory("UNCATEGORIZED");
        model.addAttribute("transactions", uncategorizedTransactions);
        return "/categorize";
    }

    @PostMapping("categorize")
    public String saveUncategorized(@PathVariable("id") final Long id, final Transaction transaction, final Model model) {
        transactionService.AddUpdateTransaction(transaction);
        return showUncategorized(model);
    }

    @GetMapping("analytics")
    public String showAnalytics(final Model model,
                                @RequestParam(name = "month") int month,
                                @RequestParam(name = "year") int year) {
        final Map<String, Double> categoryToTotal = new HashMap<>();
        for (final Transaction transaction : transactionService.findAllTransactionsByMonthAndYear(month, year)) {
            final String category = transaction.getCategory().getCategory();
            final Double total = transaction.getAmount();
            if (!categoryToTotal.containsKey(category)) {
                categoryToTotal.put(category, total);
            } else {
                categoryToTotal.put(category, categoryToTotal.get(category) + total);
            }
        }

        final List<CategoryTotal> categoryTotals = new ArrayList<>();
        for (final Map.Entry<String, Double> entry : categoryToTotal.entrySet()) {
            categoryTotals.add(CategoryTotal.builder()
                    .category(entry.getKey())
                    .totalAmount(entry.getValue())
                    .build());
        }

        model.addAttribute("categoryTotals", categoryTotals);
        return "/analytics";
    }

}
