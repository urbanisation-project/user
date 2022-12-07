package com.example.userService.payload;

import com.example.userService.model.User;
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

    public User toEntity() {
        return new User(
                this.id,
                this.name,
                this.email,
                this.password
        );
    }
}
