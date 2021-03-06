package com.asusoftware.transporter.repository;

import com.asusoftware.transporter.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/** my-transporter Created by Antonio on 12/21/2020 */
@Repository
public interface ParcelRepository extends JpaRepository<Parcel, UUID> {}
