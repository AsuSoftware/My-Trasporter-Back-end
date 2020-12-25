package com.asusoftware.transporter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

/** my-transporter Created by Antonio on 12/21/2020 */
@Getter
@Setter
@Entity
@Table(name = "parcels")
public class Parcel {

  @Id @GeneratedValue private UUID id;

  @NotNull
  @Column(name = "registered_date", nullable = false)
  private LocalDateTime registeredDate;

  @Nullable
  @Column(name = "takeover_date")
  private LocalDateTime takeoverDate;

  @Nullable
  @Column(name = "delivery_date")
  private LocalDateTime deliveryDate;

  @Nullable
  @Column(name = "details")
  private String details;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "sender_id", nullable = false)
  private User sender;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "receiver_id", nullable = false)
  private User receiver;

  @Nullable
  @ManyToOne
  @JoinColumn(name = "courier_id")
  private Employee courier;
}
