package com.jameshare.budgettracker.model.repo;

import com.jameshare.budgettracker.model.Category;
import com.jameshare.budgettracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByDateBetween(final Date publicationTimeStart, final Date publicationTimeEnd);
    List<Transaction> findAllByCategoryCategory(final String category);

}
