package com.asusoftware.transporter.repository;

import com.asusoftware.transporter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/** my-transporter Created by Antonio on 12/21/2020 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT user FROM User user WHERE user.firstName = firstName AND user.lastName = lastName AND user.email = email AND user.phone = phone")
    User findBySomeCondition(String firstName, String lastName, String email, String phone);
}
