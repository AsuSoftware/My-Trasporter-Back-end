package com.asusoftware.mytransporter.model.dto.user;

import com.asusoftware.mytransporter.model.Company;
import com.asusoftware.mytransporter.model.User;
import com.asusoftware.mytransporter.model.UserType;
import com.asusoftware.mytransporter.model.dto.company.CompanyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/22/2020
 */

@Getter
@Setter
public class UserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private UserType type;
    private CompanyDto company;

    public static UserDto mapFromEntity(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setType(user.getType());
        if(user.getCompany() != null) {
            userDto.setCompany(CompanyDto.mapFromEntity(user.getCompany()));
        }
        return userDto;
    }
}
