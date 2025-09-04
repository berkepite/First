package com.berkepite.first.service;

import com.berkepite.first.model.dto.TodoDTO;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface TodoService {
    TodoDTO createTodo(Jwt jwt, TodoDTO todo);

    List<TodoDTO> getAllTodos(Jwt jwt);

    TodoDTO getTodo(Jwt jwt, Long todoId);

    TodoDTO updateTodo(Jwt jwt, Long todoId, TodoDTO todoDTO);
}
