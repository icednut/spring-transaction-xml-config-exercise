package io.icednut.exercise.api.support;

import io.icednut.exercise.api.support.response.TodoAddResponse;
import io.icednut.exercise.infra.entity.Todo;
import io.icednut.exercise.infra.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-17
 */
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    @Transactional(readOnly = true)
    public List<Todo> getTodos() {
        //        throw new UnsupportedOperationException();
        List<Todo> todos = repository.findAll();
        todos.stream()
             .forEach(todo -> todo.setTitle("update test"));
        return todos;
    }

    public TodoAddResponse addTodo(Todo todo) {
        repository.save(todo);
        return TodoAddResponse.of("success", todo.getId());
    }
}
