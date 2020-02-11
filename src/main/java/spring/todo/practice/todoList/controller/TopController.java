package spring.todo.practice.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.todo.practice.todoList.object.TodoItem;
import spring.todo.practice.todoList.repository.TodoItemRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class TopController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/todo")
    public String getTodoList(Model model) {
        List<TodoItem> todoItemList = todoItemRepository.findAll();
        model.addAttribute("todoList", todoItemList);
        return "todo_list";
    }

    /**
     * thymeleafで、addした値をDBに登録するメソッド
     *
     * @param item  新規登録する、TODO item
     * @param model
     * @return thymeleaf
     */
    @PostMapping("/todo")
    public String postRequest(@RequestParam("registered_item") String item,
                              Model model) {

//        thymeleafの値が取得できいるかデバック出力
//        if (item == null || item.isEmpty()) {
//        } else {
//            System.out.println("register");
//        }

//      日付の取得
        LocalDateTime date1 = LocalDateTime.now();
        DateTimeFormatter dtformat1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatedDate = dtformat1.format(date1);

//      DBに登録
        TodoItem todoItem = new TodoItem();
        todoItem.setRegisterDate(formatedDate);
        todoItem.setTodoItem(item);
        todoItemRepository.save(todoItem);

//      DBから、find all したものをリストに詰める
        List<TodoItem> todoItemList = todoItemRepository.findAll();

//      リストをthymeleafにわたす
        model.addAttribute("todoList", todoItemList);

        return "todo_list";
    }

    /**
     * thymeleaf で削除した値をDBから削除するメソッド
     *
     * @param deleteId 削除する、TODO item
     * @param model
     * @return /todo にリダイレクト(GetMappingが呼ばれる)
     */
    @PostMapping("/tododelete")
    public String postRequest2(@RequestParam(name = "itemId", required = false)
                                       String deleteId, Model model) {

//      Long型に変換し、DBから削除
        todoItemRepository.deleteById(Long.valueOf(deleteId));

        return "redirect:/todo";
    }
}