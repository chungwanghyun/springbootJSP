package com.example.stpringbootjsp.model.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingForm implements Serializable {

	private static final long serialVersionUID = 1L;

//	private int currentPage = 1;
	private int limitCount;
	private int offsetCount;


}