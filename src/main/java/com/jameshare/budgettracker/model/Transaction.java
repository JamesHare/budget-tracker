package com.jameshare.budgettracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Generated
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction extends AbstractTimestampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long transactionId;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String memo;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "transactions_to_categories",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Category category;

}
