package spring.todo.practice.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.todo.practice.todoList.object.TodoItem;
import spring.todo.practice.todoList.repository.TodoItemRepository;

import java.util.List;

@Controller
public class TopController {

    @Autowired
    private  TopController topController;

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/todo")
    public String getTodoList(Model model){

        List<TodoItem> todoItemList = todoItemRepository.findAll();

        model.addAttribute("todoList", todoItemList);

        return "todo_list";
    }

    @PostMapping("/todo")
    public String postRequest(@RequestParam("registered_item")String str, Model model){

        model.addAttribute("registeredItem", str);

        return "todo_list";
    }
}
