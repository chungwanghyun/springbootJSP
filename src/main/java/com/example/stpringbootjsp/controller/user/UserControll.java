package com.example.stpringbootjsp.controller.user;

import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stpringbootjsp.model.user.UserInputModel;
import com.example.stpringbootjsp.service.file.FileService;

@Controller
@RequestMapping("/user")
public class UserControll {

	@Autowired
	FileService fileService;
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
	//	public UserInputModel init() {
	//		return new UserInputModel();
	//	}

	@GetMapping("userList")
	public String userList(Model model) throws Exception {
		return "user/userList";
	}

	@PostMapping("userList")
	public String pUserList(Model model) throws Exception {
		return "user/userList";
	}

	@GetMapping("userInput")
	public String userInput(@ModelAttribute("userInputModel") UserInputModel userInput, Model model) throws Exception {
		// 初期値設定
		initInput(model);

		return "user/userInput";
	}

	@PostMapping("/userInput")
	public String pUserInput(@ModelAttribute("userInputModel") @Validated UserInputModel userInput,
			BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			// 初期画面フラグ
			model.addAttribute("firstCheck", false);
			// 画面遷移
			return userInput(userInput, model);
		}

		if(!userInput.getUserFile1().isEmpty()) {
			fileService.save(userInput.getUserFile1(), Paths.get("/uploads"));
		}

		if(!userInput.getUserFile2().isEmpty()) {
			fileService.save(userInput.getUserFile2(), Paths.get("/uploads"));
		}

		// PRGパターンによりフォームデータの二重送信を防止
		//「POST」⇒「REDIRECT」⇒「GET」処理によってフォームデータの二重送信を防止する手法
		return "redirect:/user/userList";
		//        return "user/userList";
	}

	@PostMapping("update")
	public String update(Model model) throws Exception {
		return "user/userInput";
	}

	@PostMapping("delete")
	public String delete(Model model) throws Exception {
		return "user/userList";
	}

	@PostMapping("detail")
	public String detail(Model model) throws Exception {
		return "user/userDetail";
	}

	private void initInput(Model model) throws Exception {
		Map<Integer, String> selectMap = new LinkedHashMap<Integer, String>();
		selectMap.put(null, "--Please Select--");
		selectMap.put(1, "JAVA");
		selectMap.put(2, "PHP");
		selectMap.put(3, "C++");
		selectMap.put(4, "REACT");
		selectMap.put(5, "ANGULAR");
		model.addAttribute("favoriteList", selectMap);

		Map<Integer, String> genderMap = new LinkedHashMap<Integer, String>();
		genderMap.put(1, "男性");
		genderMap.put(2, "女性");
		model.addAttribute("genderList", genderMap);

		Map<Integer, String> hobbyMap = new LinkedHashMap<Integer, String>();
		hobbyMap.put(1, "Bird watching");
		hobbyMap.put(2, "Astronomy");
		hobbyMap.put(3, "Snowboarding");
		model.addAttribute("hobbyList", hobbyMap);

		// 初期画面フラグ
		if (model.getAttribute("firstCheck") == null) {
			model.addAttribute("firstCheck", true);
		}

	}

}
