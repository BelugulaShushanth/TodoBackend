package com.todoBackend.controller;

import com.todoBackend.model.Todo;
import com.todoBackend.model.User;
import com.todoBackend.repository.TodoRepository;
import com.todoBackend.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("localhost:4200")
@Api(tags = "Todo App")
public class TodoController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;
    @GetMapping("/user/{username}/getAllTodos")
    public List<Todo> getAllTodos(@PathVariable("username") String username){
        User user = userRepository.findById(username).get();
        return todoRepository.findByUser(user);
    }

    @PostMapping("/user/{username}/addTodo")
    public Todo addTodo(@PathVariable("username") String username,
                        @RequestBody Todo todo){
        User user = userRepository.findById(username).get();
        todo.setUser(user);
        return todoRepository.save(todo);
    }

    @PutMapping("/user/{username}/updateTodo")
    public Todo updateTodo(@PathVariable("username") String username,
                           @RequestBody Todo todo){
        Optional<Todo> todoOpt = todoRepository.findById(todo.getId());
        if(todoOpt.isPresent()){
            Todo todoEntity = todoOpt.get();
            todoEntity.setDescription(todo.getDescription());
            todoEntity.setDone(todo.isDone());
            todoEntity.setTargetDate(todo.getTargetDate());
            return todoRepository.save(todoEntity);
        }
        return todoRepository.save(todo);
    }

    @DeleteMapping("/user/{username}/deleteTodo/{id}")
    public boolean deleteTodo(@PathVariable("username") String username,
                             @PathVariable("id") int id){
        Todo todo = todoRepository.findById(id).get();
        todoRepository.delete(todo);
        return true;
    }
}
