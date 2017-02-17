package io.icednut.exercise.infra.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-17
 */
@Entity
@Table
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
