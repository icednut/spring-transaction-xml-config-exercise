package io.icednut.exercise.api.support;

import io.icednut.exercise.api.support.response.TodoAddResponse;
import io.icednut.exercise.api.support.response.TodoServiceIf;
import io.icednut.exercise.infra.entity.Todo;
import io.icednut.exercise.infra.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-17
 */
@Service
public class TodoService implements TodoServiceIf {

    @Autowired
    private TodoRepository repository;

    @Override
    public List<Todo> getTodos() {
        return repository.findAll();
    }

    @Override
    public TodoAddResponse addTodo(Todo todo) {
        repository.save(todo);
        return TodoAddResponse.of("success", todo.getId());
    }
}
