package com.berkepite.first.backend.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.berkepite.first.backend.model.Todo;
import com.berkepite.first.backend.model.dto.TodoDTO;
import com.berkepite.first.backend.repository.TodoRepository;
import com.berkepite.first.backend.service.TodoService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    TodoRepository todoRepository;
    ModelMapper modelMapper;

    @Override
    public TodoDTO createTodo(Jwt jwt, TodoDTO todoDTO) {
        UUID ownerId = UUID.fromString(jwt.getSubject());

        Todo todo = modelMapper.map(todoDTO, Todo.class);
        todo.setOwnerId(ownerId);

        return modelMapper.map(todoRepository.save(todo), TodoDTO.class);
    }

    @Override
    public List<TodoDTO> getAllTodos(Jwt jwt) {
        UUID ownerId = UUID.fromString(jwt.getSubject());
        return todoRepository.getAllTodosByOwnerId(ownerId).stream().map(t -> modelMapper.map(t, TodoDTO.class))
                .toList();
    }

    @Override
    public TodoDTO getTodo(Jwt jwt, Long todoId) {
        UUID ownerId = UUID.fromString(jwt.getSubject());

        Todo todo = todoRepository.getTodoByIdAndOwnerId(todoId, ownerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return modelMapper.map(todo, TodoDTO.class);
    }

    @Override
    public TodoDTO updateTodo(Jwt jwt, Long todoId, TodoDTO todoDTO) {
        UUID ownerId = UUID.fromString(jwt.getSubject());

        Todo todo = todoRepository.getTodoByIdAndOwnerId(todoId, ownerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        todo.setDone(todoDTO.isDone());
        todo.setText(todoDTO.getText());

        return modelMapper.map(todoRepository.save(todo), TodoDTO.class);
    }
}
