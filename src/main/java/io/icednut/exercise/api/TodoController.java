package io.icednut.exercise.api;

import io.icednut.exercise.api.support.TodoService;
import io.icednut.exercise.api.support.response.TodoAddResponse;
import io.icednut.exercise.infra.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-17
 */
@RestController
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return service.getTodos();
    }

    @PostMapping("/todos")
    public TodoAddResponse addTodo(Todo todo) {
        return service.addTodo(todo);
    }
}
