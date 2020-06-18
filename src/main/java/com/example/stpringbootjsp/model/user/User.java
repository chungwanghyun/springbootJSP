package com.example.stpringbootjsp.model.user;

import java.util.Date;

import lombok.Data;

@Data
public class User {/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.seq
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private Long seq;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.id
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.favorite
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private Integer favorite;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.hobby
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private String hobby;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.gender
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private Integer gender;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.file_seq_1
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private Long fileSeq1;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.file_seq_2
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private Long fileSeq2;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.birthday
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private Date birthday;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.c_datetime
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private Date cDatetime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.c_user
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private String cUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.u_datetime
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private Date uDatetime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.u_user
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private String uUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.d_datetime
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private Date dDatetime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.d_user
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private String dUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.memo
	 * @mbg.generated  Thu Jun 18 10:44:14 JST 2020
	 */
	private String memo;

}