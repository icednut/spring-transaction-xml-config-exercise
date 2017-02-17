package io.icednut.exercise.infra.repository;

import io.icednut.exercise.infra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-16
 */
public interface HelloRepository extends JpaRepository<User, Long> {
}
