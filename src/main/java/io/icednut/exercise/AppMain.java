package io.icednut.exercise;

import io.icednut.exercise.infra.entity.Todo;
import io.icednut.exercise.infra.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-20
 */
@SpringBootApplication
public class AppMain {

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TodoRepository repository) {
        return args -> {
            Todo todo = new Todo();

            todo.setTitle("readOnly Test");
            todo.setContent("readOnly Test (Content)");
            repository.save(todo);
        };
    }
}
