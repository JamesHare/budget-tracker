package com.jameshare.budgettracker.service;

import com.jameshare.budgettracker.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    List<Transaction> findAllTransactionsByMonthAndYear(final int month, final int year);
    List<Transaction> findAllByCategory(final String category);
    Optional<Transaction> findTransaction(long id);
    void AddUpdateTransaction(final Transaction transaction);

}
