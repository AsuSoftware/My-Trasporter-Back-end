package com.asusoftware.transporter.service.user.impl;

import com.asusoftware.transporter.model.Address;
import com.asusoftware.transporter.model.User;
import com.asusoftware.transporter.model.dto.address.AddressDto;
import com.asusoftware.transporter.model.dto.user.CreateUserDto;
import com.asusoftware.transporter.repository.UserRepository;
import com.asusoftware.transporter.service.user.UserCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * transporter Created by Antonio on 12/25/2020
 */

@Service
@RequiredArgsConstructor
public class UserCreatorImpl implements UserCreator {

    private final UserRepository userRepository;

    @Override
    public void create(CreateUserDto createUserDto) {
        userRepository.save(mapUserDtoToEntity(createUserDto));
    }

    private User mapUserDtoToEntity(CreateUserDto createUserDto) {
        User user = new User();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setPhone(createUserDto.getPhone());
        if (createUserDto.getAddress() != null) {
            user.setAddress(mapAddressDtoToEntity(createUserDto.getAddress()));
        }
        return user;
    }

    private Address mapAddressDtoToEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setStreet(addressDto.getStreet());
        address.setStreetNumber(addressDto.getStreetNumber());
        address.setDetails(addressDto.getDetails());
        address.setZip(addressDto.getZip());
        return address;
    }
}
