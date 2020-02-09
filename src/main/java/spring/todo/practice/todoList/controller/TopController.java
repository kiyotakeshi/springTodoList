package spring.todo.practice.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {

    @Autowired
    private  TopController topController;

    @GetMapping("/todo")
    public String getTodoList(){
        return "todo_list";
    }

}
