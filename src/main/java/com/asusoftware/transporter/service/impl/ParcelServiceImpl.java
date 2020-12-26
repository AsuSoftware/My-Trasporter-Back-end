package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.exception.ParcelNotFoundException;
import com.asusoftware.transporter.model.Parcel;
import com.asusoftware.transporter.model.User;
import com.asusoftware.transporter.model.dto.AddressDto;
import com.asusoftware.transporter.model.dto.CreateParcelDto;
import com.asusoftware.transporter.model.dto.CreateUserDto;
import com.asusoftware.transporter.model.dto.ParcelDto;
import com.asusoftware.transporter.repository.ParcelRepository;
import com.asusoftware.transporter.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.UUID;

/** transporter Created by Antonio on 12/25/2020 */
@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    @Override
    public void create(CreateParcelDto createParcelDto) {
      parcelRepository.save(createParcel(createParcelDto));
    }

    @Override
    public ParcelDto findById(UUID id) {
        return ParcelDto.mapFromEntity(parcelRepository.findById(id).orElseThrow(ParcelNotFoundException::new));
    }

    private Parcel createParcel(CreateParcelDto createParcelDto) {
        Parcel parcel = new Parcel();
        parcel.setRegisteredDate(LocalDateTime.now(ZoneOffset.UTC));
        parcel.setSender(createUser(createParcelDto.getSender()));
        parcel.setReceiver(createUser(createParcelDto.getReceiver()));
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
        return user;
    }
}
