package com.asusoftware.mytransporter.repository;

import com.asusoftware.mytransporter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
