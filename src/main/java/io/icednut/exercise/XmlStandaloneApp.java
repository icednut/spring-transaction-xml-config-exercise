package io.icednut.exercise;

import io.icednut.exercise.api.support.TodoService;
import io.icednut.exercise.infra.entity.Todo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.List;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-22
 */
public class XmlStandaloneApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/database-config.xml", XmlStandaloneApp.class);

        TransactionInterceptor bean = ctx.getBean(TransactionInterceptor.class);

        TodoService todoService = ctx.getBean("todoService", TodoService.class);
        List<Todo> todos = todoService.getTodos();
        System.out.println(todos.size());
    }
}
