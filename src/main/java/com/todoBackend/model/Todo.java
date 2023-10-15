package com.todoBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "Todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;
    private Date targetDate;
    private boolean isDone;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_fk")
    @JsonIgnore
    private User user;
}
