package com.jameshare.budgettracker.service;

import com.jameshare.budgettracker.model.Category;
import com.jameshare.budgettracker.model.repo.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(final CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> findAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category addCategory(final Category category) {
        return repository.save(category);
    }
}
