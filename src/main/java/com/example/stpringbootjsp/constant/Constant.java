package com.example.stpringbootjsp.constant;

public interface Constant {

//	String ROOT_PATH = "/UPLOAD/"; //本番用(事前に作成)
	String ROOT_PATH = "c://uploads/"; //local用
	String USER_TEMP_PATH = ROOT_PATH + "TEMP/";
	String USER_PATH = ROOT_PATH + "USER/";

	String DATE_FORMAT_1 = "MM/dd/yyyy";
}
