package com.jameshare.budgettracker.service;

import com.jameshare.budgettracker.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAllTransactionsByMonthAndYear(final int month, final int year);
    List<Transaction> findAllByCategory(final String category);

}
