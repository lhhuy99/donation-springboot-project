package com.huylhfx13483.assignment1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huylhfx13483.assignment1.entity.User;
import com.huylhfx13483.assignment1.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User theUser) {
		return userRepository.save(theUser);
	}

	@Override
	public User getUserById(int theId) {
		Optional<User> result = userRepository.findById(theId);

		User user = null;
		if (result.isPresent()) {
			user = result.get();
		} else {
			throw new RuntimeException("Did not find user id - " + theId);
		}

		return user;
	}

	@Override
	public void deleteUser(int theId) {
		userRepository.deleteById(theId);
	}

}
