package com.example.stpringbootjsp.model.user;

import com.example.stpringbootjsp.model.common.PagingModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListModel extends PagingModel {

	private String id;
	private Integer favorite;
	private String hobby;

}
