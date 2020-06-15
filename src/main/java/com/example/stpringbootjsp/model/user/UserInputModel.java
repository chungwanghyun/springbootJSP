package com.example.stpringbootjsp.model.user;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserInputModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{validation.required}")
	@Size(min = 0, max = 1, message = "{validation.max-length}")
	private String id;
	@NotEmpty(message = "{validation.required}")
	private String password;
	private Integer favorite;
	private List<Integer> hobby;
	private Integer gender;
	private String memo;
	private MultipartFile userFile1;
	private String userFileTemp1;
	private MultipartFile userFile2;
	private String userFileTemp2;
}
