package com.asusoftware.mytransporter.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

/** my-transporter Created by Antonio on 12/21/2020 */

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {

    @Id @GeneratedValue private UUID id;

    @NotNull
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Email
    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    // Employee
    @OneToMany(mappedBy = "company")
    private List<User> userList;

}
