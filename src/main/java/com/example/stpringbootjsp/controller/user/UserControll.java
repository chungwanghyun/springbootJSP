package com.example.stpringbootjsp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserControll {

	// 追加
//    @ModelAttribute
//    public TopModel setUpForm() {
//        return new TopModel();
//    }

    @GetMapping("list")
    public String list(Model model) {
        return "user/userList";
    }

    @PostMapping("list")
    public String pList(Model model) {
        return "user/userList";
    }

    @PostMapping("add")
    public String add(Model model) {
        return "user/userInput";
    }

    @PostMapping("update")
    public String update(Model model) {
        return "user/userInput";
    }

    @PostMapping("delete")
    public String delete(Model model) {
        return "user/userList";
    }

    @PostMapping("detail")
    public String detail(Model model) {
        return "user/userDetail";
    }

}
