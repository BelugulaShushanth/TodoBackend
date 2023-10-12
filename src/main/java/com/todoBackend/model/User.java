package com.todoBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "User")
public class User {

    @Id
    private String username;
    private String password;
}
