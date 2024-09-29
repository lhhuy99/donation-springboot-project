package com.huylhfx13483.assignment1.service;

import java.util.List;

import com.huylhfx13483.assignment1.entity.User;

public interface UserService {

	public List<User> getUsers();

	public User saveUser(User theUser);

	public User getUserById(int theId);

	public void deleteUser(int theId);
}
