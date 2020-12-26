package com.asusoftware.transporter.model.dto;

import com.asusoftware.transporter.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;
import java.util.UUID;

/**
 * transporter Created by Antonio on 12/26/2020
 */

@Getter
@Setter
public class UserDto {

    private UUID id;
   @NotBlank private String firstName;
   @NotBlank private String lastName;
   @Email @Nullable private String email;
   @Nullable private String phone;
   @Nullable private AddressDto address;

    public static UserDto mapFromEntity(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(Optional.ofNullable(user.getAddress()).map(AddressDto::mapFromEntity).orElse(null));
        return userDto;
    }
}
