package com.berkepite.first.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berkepite.first.backend.model.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> getTodoByIdAndOwnerId(Long id, UUID ownerId);

    List<Todo> getAllTodosByOwnerId(UUID ownerId);
}
