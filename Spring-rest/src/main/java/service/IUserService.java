package com.sumon.api.service;

import java.util.List;
import com.sumon.api.entity.User;
import com.sumon.api.exception.UserAlreadyExistException;
import com.sumon.api.exception.UserNotFound;

public interface IUserService {

	List<User> findAll();
	User findOne(String id)throws UserNotFound;
	User create(User user) throws UserAlreadyExistException;
	User update(String id, User user) throws UserNotFound;
    void delete(String id) throws UserNotFound;

}
