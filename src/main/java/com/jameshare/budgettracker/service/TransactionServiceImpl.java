package com.jameshare.budgettracker.service;

import com.jameshare.budgettracker.model.Category;
import com.jameshare.budgettracker.model.Transaction;
import com.jameshare.budgettracker.model.repo.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(final TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transaction> findAllTransactionsByMonthAndYear(final int month, final int year) {
        Calendar gc = new GregorianCalendar();
        gc.set(year, month, 1);
        final Date start = gc.getTime();
        gc.set(year, month, -1);
        final Date end = gc.getTime();
        return repository.findAllByDateBetween(start, end);
    }

    @Override
    public List<Transaction> findAllByCategory(final String category) {
        return repository.findAllByCategoryCategory(category);
    }
}
