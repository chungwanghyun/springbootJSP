package com.example.stpringbootjsp.controller.user;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.stpringbootjsp.constant.Constant;
import com.example.stpringbootjsp.model.user.UserInputForm;
import com.example.stpringbootjsp.model.user.UserList;
import com.example.stpringbootjsp.model.user.UserListForm;
import com.example.stpringbootjsp.service.file.FileService;
import com.example.stpringbootjsp.service.user.UserService;

//@Slf4j
@Controller
@RequestMapping("/user")
public class UserControll {

	@Autowired
	FileService fileService;

	@Autowired
	UserService userService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
    HttpSession session;

	@GetMapping("list")
	public String list(Model model) throws Exception {
		// 検索
		return search(new UserListForm(), Optional.ofNullable(null), Optional.ofNullable(null), model);
	}

	@PostMapping("search")
	public String search(@ModelAttribute("userListForm") UserListForm userListForm,
						Optional<Integer> page, Optional<Integer> size, Model model) throws Exception {
		// 検索条件保存
		session.setAttribute("userListModel", userListForm);

		// ページリスト取得
		Page<UserList> userList = userService.list(userListForm, page, size);
		// ページ数取得
		List<Integer> pageNumbers = userService.pageNumber(userList);
		if(pageNumbers.size() > 0) {
			// ページ数設定
            model.addAttribute("pageNumbers", pageNumbers);
		}

        // フォーム情報設定
        model.addAttribute("userListForm", userListForm);
        // リスト情報設定
		model.addAttribute("userList", userList);
		return "user/list";
	}

	@GetMapping("paging")
	public String paging(@RequestParam("page") Optional<Integer> page,
						@RequestParam("size") Optional<Integer> size,
						Model model) throws Exception {
		// 検索条件呼び出し
		UserListForm form = (UserListForm)session.getAttribute("userListModel");
		// 検索
		return search(form, page, size, model);
	}

	@GetMapping("input")
	public String input(@ModelAttribute("userInputForm") UserInputForm userInputForm, Model model, Locale locale)
			throws Exception {
		// 初期値設定
		initInput(model);

		return "user/input";
	}

	@PostMapping("input")
	public String pInput(@ModelAttribute("userInputForm") @Validated UserInputForm userInputForm,
			BindingResult result, Model model, Locale locale) throws Exception {
		// 入力チェック(Bean Validated用以外)
		isValid(userInputForm, result, locale);

		// 入力チェック結果判断(Bean Validated用)
		if (result.hasErrors()) {
			// 初期画面フラグ
			model.addAttribute("firstCheck", false);
			// 画面遷移
			return input(userInputForm, model, locale);
		}

		try {
			// ユーザー登録
			userService.insertUser(userInputForm);
		} catch (IOException ex) {
			throw new Exception(ex);
		} catch (Exception ex) {
			//			log.error(ex.getMessage());
			throw new Exception(ex);
		}

		// PRGパターンによりフォームデータの二重送信を防止
		//「POST」⇒「REDIRECT」⇒「GET」処理によってフォームデータの二重送信を防止する手法
		return "redirect:/user/list";
		//        return "user/userList";
	}

	@PostMapping("update")
	public String update(Model model) throws Exception {
		return "user/input";
	}

	@PostMapping("delete")
	public String delete(Model model) throws Exception {
		return "user/list";
	}

	@PostMapping("detail")
	public String detail(Model model) throws Exception {
		return "user/detail";
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

	@PostMapping("saveTempFile")
	@ResponseBody
	public boolean saveTempFile(@RequestParam("file") MultipartFile uploadfile, Model model) throws Exception {
		boolean result = false;
		// ディレクトリー作成
		fileService.makeDir(Paths.get(Constant.USER_TEMP_PATH));
		if (!uploadfile.isEmpty()) {
			result = fileService.save(uploadfile, Paths.get(Constant.USER_TEMP_PATH));
		}
		return result;
	}

	/**
	 * 入力チェック
	 *
	 * @param userInput
	 * @param result
	 * @param locale
	 */
	private void isValid(UserInputForm userInput, BindingResult result, Locale locale) {

		// Tempファイルチェック
		if (userInput.getUserFileTemp1() == null || userInput.getUserFileTemp1().length() == 0) {
			// ファイルチェック
			if (userInput.getUserFile1().isEmpty()) {
				String message = messageSource.getMessage("validation.required", new String[] { "userFile1" }, locale);
				FieldError fieldError = new FieldError(result.getObjectName(), "userFile1", message);
				result.addError(fieldError);
			}
		}

		// Tempファイルチェック
		if (userInput.getUserFileTemp2() == null || userInput.getUserFileTemp2().length() == 0) {
			// ファイルチェック
			if (userInput.getUserFile2().isEmpty()) {
				String message = messageSource.getMessage("validation.required", new String[] { "userFile2" }, locale);
				FieldError fieldError = new FieldError(result.getObjectName(), "userFile2", message);
				result.addError(fieldError);
			}
		}
	}

}
