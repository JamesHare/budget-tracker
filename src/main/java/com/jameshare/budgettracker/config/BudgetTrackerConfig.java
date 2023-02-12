package com.jameshare.budgettracker.config;

import com.jameshare.budgettracker.model.Category;
import com.jameshare.budgettracker.service.CategoryService;
import jakarta.annotation.PostConstruct;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Generated
@EnableTransactionManagement
@Configuration
@Slf4j
@EnableConfigurationProperties({ BudgetTrackerConfigProperties.class })
public class BudgetTrackerConfig {

    private final CategoryService categoryService;
    private final BudgetTrackerConfigProperties properties;

    public BudgetTrackerConfig(final CategoryService categoryService,
                               final BudgetTrackerConfigProperties properties) {
        this.categoryService = categoryService;
        this.properties = properties;
    }

    @PostConstruct
    public void init() {
        try {
            List<String> existingCategories = categoryService
                    .findAllCategories().stream().map(Category::getCategory).toList();

            for (final String category : properties.getCategories()) {
                if (!existingCategories.contains(category)) {
                    categoryService.addCategory(Category.builder().category(category).build());
                }
            }
            log.info("Categories added to database");
        } catch (final Exception e) {
            log.error("An error occurred when trying to add categories to database.", e);
        }
    }

}
