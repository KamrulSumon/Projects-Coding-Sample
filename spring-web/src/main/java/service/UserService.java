package com.sumon.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sumon.api.entity.User;

@Service
public class UserService {

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		users.add(new User(UUID.randomUUID().toString(), "Kamrul", "Hasan", "hasanm@goldmail.etsu.edu", "ETSU"));
		users.add(new User(UUID.randomUUID().toString(), "Sumon", "Hasan", "hasanm@goldmail.etsu.edu", "ETSU"));
		users.add(new User(UUID.randomUUID().toString(), "Kamrul", "Sumon", "hasanm@goldmail.etsu.edu", "ETSU"));
		users.add(new User(UUID.randomUUID().toString(), "Sumon", "Kamrul", "hasanm@goldmail.etsu.edu", "ETSU"));
		return users;
	}

	public User findOne(String id) {
		String someid = UUID.randomUUID().toString();
		return new User(someid, "Kamrul", "Hasan", "hasanm@goldmail.etsu.edu", "ETSU");
	}

	public User create(User user) {
		String someid = UUID.randomUUID().toString();
		user.setId(someid);

		return user;
	}

}
