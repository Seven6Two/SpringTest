package com.seven6two.examples.springtest.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private int accountId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_number")
    private int accountNumber;

    @ElementCollection
    @CollectionTable(name = "customer_accounts")
    private List<String> customerIds;

}
