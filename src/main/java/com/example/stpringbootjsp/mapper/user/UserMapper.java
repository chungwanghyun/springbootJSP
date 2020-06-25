package com.example.stpringbootjsp.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.stpringbootjsp.model.user.User;
import com.example.stpringbootjsp.model.user.UserList;
import com.example.stpringbootjsp.model.user.UserListModel;

@Mapper
public interface UserMapper {

  	int insertUser(User userParam);

    int updateUser(User userParam);

    int deleteUser(User userParam);

    List<UserList> listUser(UserListModel userListModel);

    long listUserCount(UserListModel userListModel);

}