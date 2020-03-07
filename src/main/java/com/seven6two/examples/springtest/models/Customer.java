package com.seven6two.examples.springtest.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;


@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "first_name")
    @Length(min = 1)
    @NotEmpty(message = "*Please provide your first name")
    private String forename;

    @Column(name = "last_name")
    @Length(min = 1)
    @NotEmpty(message = "*Please provide your surname")
    private String surname;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @ElementCollection
    @CollectionTable(name = "customer_accounts")
    private List<String> accountIds;

}

