package com.jameshare.budgettracker.service;

import com.jameshare.budgettracker.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategories();
    Category addCategory(final Category category);

}
