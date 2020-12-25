package com.asusoftware.transporter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

/** my-transporter Created by Antonio on 12/21/2020 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  @Id @GeneratedValue private UUID id;

  @NotBlank
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotBlank
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Email
  @Nullable
  @Column(name = "email")
  private String email;

  @Nullable
  @Column(name = "phone")
  private String phone;

  @Nullable
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "address_id")
  private Address address;
}
