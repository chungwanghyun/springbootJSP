package com.example.stpringbootjsp.model.user;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserInputModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{validation.required}")
	@Size(min = 8, max = 50, message = "{validation.size-length}")
	private String id;
	@NotEmpty(message = "{validation.required}")
	@Size(min = 8, max = 50, message = "{validation.size-length}")
	private String password;
	@NotNull(message = "{validation.required}")
	private Integer favorite;
	@NotEmpty(message = "{validation.required}")
	private String hobby;
//	@NotEmpty(message = "{validation.required}")
//	@Size(min = 0, max = 50, message = "{validation.size-length}")
	@NotNull(message = "{validation.required}")
	private Integer gender;
	@Size(min = 0, max = 10000, message = "{validation.max-length}")
	private String memo;
	private MultipartFile userFile1;
	private String userFileTemp1;
	private MultipartFile userFile2;
	private String userFileTemp2;

//	@Max(value = 10, message = "{validation.required}")
//	@Min(value = 0, message = "{validation.required}")
	@NotNull(message = "{validation.required}")
	private Integer money;

	@NotEmpty(message = "{validation.required}")
	// Date->String
	private String birthday;
}
