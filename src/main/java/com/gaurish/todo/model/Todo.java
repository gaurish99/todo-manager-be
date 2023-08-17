package com.gaurish.todo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;

@Entity
@Table(name = "todos")
@Data
public class Todo {

    @Id
    private String id;
    @Column(name = "todo_title")
    String title;
    @Column(name = "todo_summary")
    String summary;
    @Column(name = "todo_complete")
    boolean complete;
}
