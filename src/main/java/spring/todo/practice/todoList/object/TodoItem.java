package spring.todo.practice.todoList.object;

import lombok.Data;
import spring.todo.practice.todoList.util.dataConstants;

import javax.persistence.*;

@Entity
@Data
@Table(name = dataConstants.TODO_LIST_TABLE)
public class TodoItem {

    @Id
    @Column(name = dataConstants.ITEM_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long itemId;

    @Column(name = dataConstants.REGISTER_DATE)
    public String registerDate;

    @Column(name = dataConstants.TODO_ITEM)
    public String todoItem;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }
}

