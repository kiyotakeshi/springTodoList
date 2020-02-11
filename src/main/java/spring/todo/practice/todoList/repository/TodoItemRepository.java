package spring.todo.practice.todoList.repository;

import org.springframework.stereotype.Repository;
import spring.todo.practice.todoList.object.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * CRUD操作をするクラスを継承し、今回のプログラムで使用する名前に変更
 */
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
