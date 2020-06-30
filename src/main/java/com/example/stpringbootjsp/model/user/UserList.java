package com.example.stpringbootjsp.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserList extends User {

	private int limitCount;
	private int offsetCount;
	private String sort;

}