package com.example.stpringbootjsp.controller.top;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stpringbootjsp.model.top.TopModel;

@Controller
@RequestMapping("/")
public class TopControll {

	// 追加
    @ModelAttribute
    public TopModel setUpForm() {
        return new TopModel();
    }

    @GetMapping("/")
    public String top() {
        return "top/top";
    }

    @PostMapping("/top")
    public String top(Model model) {
        return "top/top";
    }

    // 追加
    @PostMapping("/login")
    public String login(TopModel topModel, Model model) {

        model.addAttribute("id", topModel.getId());
        model.addAttribute("password", new String(topModel.getPassword()));

        return "top/top";
    }
}
