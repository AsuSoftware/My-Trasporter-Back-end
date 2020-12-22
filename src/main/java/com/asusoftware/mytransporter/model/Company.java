package com.asusoftware.mytransporter.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String name;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    // @TODO add price per kg

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name="couriers_id")
    private List<User> couriers;

}
