package com.asusoftware.transporter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

  @Id @GeneratedValue private UUID id;

  @NotBlank
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotBlank
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Email
  @NotBlank
  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Nullable
  @Column(name = "phone")
  private String phone;

  @Nullable
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "address_id")
  private Address address;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "company_id", nullable = false)
  private Company company;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "employee_role", nullable = false)
  private EmployeeRole role;
}
