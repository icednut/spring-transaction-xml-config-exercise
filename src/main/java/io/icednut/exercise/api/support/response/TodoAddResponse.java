package io.icednut.exercise.api.support.response;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-17
 */
public class TodoAddResponse {
    private final String message;
    private final Long todoId;

    private TodoAddResponse(String message, Long todoId) {
        this.message = message;
        this.todoId = todoId;
    }

    public String getMessage() {
        return message;
    }

    public Long getTodoId() {
        return todoId;
    }

    public static TodoAddResponse of(String message, Long todoId) {
        return new TodoAddResponse(message, todoId);
    }
}
