package com.example.stpringbootjsp.controller.top;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stpringbootjsp.model.top.TopModel;

@Controller
@RequestMapping("/")
public class TopControll {

//	// 追加
//    @ModelAttribute
//    public TopModel setUpForm() {
//        return new TopModel();
//    }

    @GetMapping("/")
    public String root(TopModel topModel) {
        return "top/top";
    }

    @PostMapping("/")
    public String pRoot(TopModel topModel) {
        return "top/top";
    }

    @PostMapping("/top")
    public String pTop(TopModel topModel) {
        return "top/top";
    }

//    @PostMapping("/login")
//    public String pLogin(TopModel topModel, Model model) {
//
//        model.addAttribute("id", topModel.getId());
//        model.addAttribute("password", new String(topModel.getPassword()));
//
//        return "top/top";
//    }
}
