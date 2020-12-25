package com.asusoftware.transporter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/** my-transporter Created by Antonio on 12/21/2020 */
@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {

  @Id @GeneratedValue private UUID id;

  @NotBlank
  @Column(name = "name", nullable = false)
  private String name;

  @Nullable
  @Column(name = "description")
  private String description;

  @Nullable
  @Column(name = "image")
  private String image;

  @Nullable
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "address_id")
  private Address address;

  @OneToMany(mappedBy = "company")
  private Set<Employee> employees = new HashSet<>();
}
