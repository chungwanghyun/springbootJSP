package com.example.stpringbootjsp.model.user;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserInputModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Please enter your username")
	@Size(min = 0, max = 1, message = "{validation.max-length}")
	private String id;
	 @NotEmpty(message = "Please enter your password")
	private String password;

}
