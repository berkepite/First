package com.berkepite.first.controller;

import com.berkepite.first.model.dto.TodoDTO;
import com.berkepite.first.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/todo")
public class TodoController {
    private TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<TodoDTO> createTodo(@AuthenticationPrincipal Jwt jwt, @RequestBody TodoDTO todoDTO) {
        TodoDTO created = todoService.createTodo(jwt, todoDTO);
        URI location = URI.create("/api/v1/todos/" + created.getId());

        return ResponseEntity.created(location).body(created);
    }

    @GetMapping("/get/{todoId}")
    public ResponseEntity<TodoDTO> getTodo(@AuthenticationPrincipal Jwt jwt, @PathVariable Long todoId) {
        return ResponseEntity.ok().body(todoService.getTodo(jwt, todoId));
    }

    @GetMapping("/get")
    public ResponseEntity<List<TodoDTO>> getTodos(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok().body(todoService.getAllTodos(jwt));
    }

    @PutMapping("/update/{todoId}")
    public ResponseEntity<TodoDTO> getTodos(@AuthenticationPrincipal Jwt jwt,
                                            @PathVariable Long todoId,
                                            @RequestBody TodoDTO todoDTO) {
        return ResponseEntity.ok().body(todoService.updateTodo(jwt, todoId, todoDTO));
    }
}
