package com.asusoftware.mytransporter.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/** my-transporter Created by Antonio on 12/21/2020 */

@Getter
@Setter
@Entity
@Table(name = "packages")
public class Package {

    @Id @GeneratedValue
    private UUID id;

    // in viitor vor fii obiecte address
    @NotNull
    @Column(name = "location", nullable = false)
    private String location;

    // in viitor vor fii obiecte address
    @NotNull
    @Column(name = "destination", nullable = false)
    private String destination;

    @NotNull
    @Column(name = "data_destination")
    private LocalDateTime date;

    @NotNull
    @Column(name = "kg")
    private Double kg;

    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false)
    private User recipient;

    @ManyToOne
    @JoinColumn(name="sender_id", nullable=false)
    private User sender;

}
