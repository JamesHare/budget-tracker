package com.jameshare.budgettracker.model;

import jakarta.persistence.*;
import lombok.*;

@Generated
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category extends AbstractTimestampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long categoryId;

    @Column(nullable = false)
    private String category;

}
