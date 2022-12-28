package com.example.userService.payload;

import com.example.userService.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPayload {
    private Long id;
    private String name;
    private String email;
    private String password;

    public Owner toEntity() {
        return new Owner(
                getId(),
                getName(),
                getEmail(),
                getPassword()
        );
    }
}
