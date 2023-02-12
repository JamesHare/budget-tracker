package com.jameshare.budgettracker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "budget-tracker.config")
public class BudgetTrackerConfigProperties {

    private List<String> categories;

}
