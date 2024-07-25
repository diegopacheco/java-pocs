package com.github.diegopacheco.sandboxspring.repository;

import com.github.diegopacheco.sandboxspring.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    int countAllByCompleted(boolean completed);
    List<TodoItem> findAllByCompleted(boolean completed);
}