package com.asusoftware.mytransporter.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/** my-transporter Created by Antonio on 12/21/2020 */

@Getter
@Setter
@Entity
@Table(name = "packages")
public class Package {

    @Id @GeneratedValue
    private UUID id;

    @NotNull
    @Column(name = "location", nullable = false)
    private String location;

    @NotNull
    @Column(name = "destination", nullable = false)
    private String destination;

    @NotNull
    @Column(name = "data_destination")
    private Date dataDestination;

    @NotNull
    @Column(name = "kg")
    private Double kg;

    @NotNull
    @Column(name = "phone")
    private String destination_phone;

    @Column(name = "taker")
    private String taker_name;

}
