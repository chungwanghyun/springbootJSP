package com.example.stpringbootjsp.model.user;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Integer favorite;
	private String hobby;

	private String sort;

}
