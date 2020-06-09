package com.example.stpringbootjsp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stpringbootjsp.model.user.UserInputModel;

@Controller
@RequestMapping("/user")
public class UserControll {

	// 追加
//    @ModelAttribute
//    public TopModel setUpForm() {
//        return new TopModel();
//    }

//    @ModelAttribute
//    public UserInputModel setupForm() {
//    	UserInputModel userInputModel = new UserInputModel();
//        return userInputModel;
//    }

	@ModelAttribute
	public UserInputModel init() {
		return new UserInputModel();
	}

    @GetMapping("list")
    public String list(Model model) {
        return "user/userList";
    }

    @PostMapping("list")
    public String pList(Model model) {
        return "user/userList";
    }

    @GetMapping("input")
    public String input(@ModelAttribute("userInputModel") UserInputModel userInput) {
        return "user/userInput";
    }

    @PostMapping("/input")
    public String postInput(@ModelAttribute("userInputModel") @Validated UserInputModel userInput, BindingResult result, Model model) {
    	//ポイント2
        if (result.hasErrors()) {
            return input(userInput);
        }
    	// PRGパターンによりフォームデータの二重送信を防止
    	//「POST」⇒「REDIRECT」⇒「GET」処理によってフォームデータの二重送信を防止する手法
        return "redirect:/user/list";
//        return "user/userList";
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
