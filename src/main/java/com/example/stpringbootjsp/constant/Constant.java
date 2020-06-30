package com.example.stpringbootjsp.constant;

public interface Constant {

//	String ROOT_PATH = "/UPLOAD/"; //本番用(事前に作成)
	String ROOT_PATH = "c://uploads/"; //local用
	String USER_TEMP_PATH = ROOT_PATH + "TEMP/";
	String USER_PATH = ROOT_PATH + "USER/";

	String DATE_FORMAT_1 = "MM/dd/yyyy";

	Integer PAGE_COUNT_0 = 0;
	Integer PAGE_COUNT_1 = 1;
	Integer PAGE_COUNT_2 = 2;
	Integer PAGE_COUNT_10 = 10;
	Integer PAGE_COUNT_20 = 20;
	Integer PAGE_COUNT_50 = 50;
	Integer PAGE_COUNT_100 = 100;

	Integer MAX_PAGE_10 = 10;
}
