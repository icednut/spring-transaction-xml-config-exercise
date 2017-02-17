package io.icednut.exercise.api.support.response;

import io.icednut.exercise.infra.entity.Todo;

import java.util.List;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-17
 */
public interface TodoServiceIf {
    List<Todo> getTodos();

    TodoAddResponse addTodo(Todo todo);
}
