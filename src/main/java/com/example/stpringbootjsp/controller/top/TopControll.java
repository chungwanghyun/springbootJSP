package com.example.stpringbootjsp.controller.top;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stpringbootjsp.model.top.TopModel;

@Controller
@RequestMapping("/")
public class TopControll {

    @GetMapping("/")
    public String root(TopModel topModel) throws Exception {
        return "top/top";
    }

    @PostMapping("/")
    public String pRoot(TopModel topModel) throws Exception {
        return "top/top";
    }

    @PostMapping("/top")
    public String pTop(TopModel topModel) throws Exception {
        return "top/top";
    }
}
