package spring.todo.practice.todoList.repository;

import org.springframework.stereotype.Repository;
import spring.todo.practice.todoList.object.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

    List<TodoItem> findAll();

}
