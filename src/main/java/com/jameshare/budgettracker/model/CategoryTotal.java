package com.jameshare.budgettracker.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class CategoryTotal {

    private final String category;
    private final double totalAmount;

}
