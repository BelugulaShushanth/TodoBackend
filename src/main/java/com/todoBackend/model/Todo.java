package com.todoBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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
