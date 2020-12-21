package com.asusoftware.mytransporter.model.dto.user;

import lombok.*;

import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUserDto {
    private UUID id;
    private String username;
    private String token;
}
