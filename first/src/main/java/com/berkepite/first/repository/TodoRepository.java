package com.berkepite.first.repository;

import com.berkepite.first.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> getTodoByIdAndOwnerId(Long id, UUID ownerId);

    List<Todo> getAllTodosByOwnerId(UUID ownerId);
}
