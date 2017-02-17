package io.icednut.exercise.infra.repository;

import io.icednut.exercise.infra.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-17
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
