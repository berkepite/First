package com.berkepite.first.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "todo", schema = "first")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "UUID")
    private UUID ownerId;
    @Column(name = "text", columnDefinition = "TEXT")
    private String text;
    @Column(name = "done")
    private boolean done;
}
