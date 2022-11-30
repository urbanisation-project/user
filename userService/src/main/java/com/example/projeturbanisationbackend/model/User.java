package com.example.projeturbanisationbackend.model;

import com.example.projeturbanisationbackend.payload.UserPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public UserPayload toPayload() {
        return new UserPayload(
                this.id,
                this.name,
                this.email,
                this.password
        );
    }
}
