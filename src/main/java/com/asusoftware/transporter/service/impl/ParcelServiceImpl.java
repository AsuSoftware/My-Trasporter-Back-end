package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.exception.ParcelNotFoundException;
import com.asusoftware.transporter.exception.UserNotFoundException;
import com.asusoftware.transporter.model.Parcel;
import com.asusoftware.transporter.model.User;
import com.asusoftware.transporter.model.dto.*;
import com.asusoftware.transporter.repository.ParcelRepository;
import com.asusoftware.transporter.repository.UserRepository;
import com.asusoftware.transporter.service.ParcelService;
import com.asusoftware.transporter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/** transporter Created by Antonio on 12/25/2020 */
@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;
    private final UserRepository userRepository;

    @Override
    public void create(CreateParcelDto createParcelDto) {
      parcelRepository.save(createParcel(createParcelDto));
    }

    @Override
    public Parcel findById(UUID id) {
        return parcelRepository.findById(id).orElseThrow(ParcelNotFoundException::new);
    }

    private Parcel createParcel(CreateParcelDto createParcelDto) {
        Parcel parcel = new Parcel();
        User sender = findUser(createParcelDto.getSender());
        User receiver = findUser(createParcelDto.getReceiver());
        parcel.setRegisteredDate(LocalDateTime.now(ZoneOffset.UTC));
        parcel.setSender((sender != null) ? sender : createUser(createParcelDto.getSender()));
        parcel.setReceiver((receiver != null) ? receiver : createUser(createParcelDto.getReceiver()));
        parcel.setDetails(createParcelDto.getDetails());
        // @TODO Sa vedem ce facem cu Id de la companie, cum sa implementam daca un employee e free sau nu
        return parcel;
    }

    private User createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setPhone(createUserDto.getPhone());
        user.setAddress(
                Optional.ofNullable(createUserDto.getAddress()).map(AddressDto::toAddress).orElse(null));
        return userRepository.save(user);
    }

    private Optional<User> findUser(CreateUserDto userDto) {
        return userRepository.findByFistNameAndLastNameAndEmailAndPhone(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhone();
    }
}
