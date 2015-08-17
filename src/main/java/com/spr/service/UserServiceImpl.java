package com.spr.service;

import com.spr.exception.UserNotFound;
import com.spr.model.User;
import com.spr.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	@Transactional
	public User create(User user) {
		User createdUser = user;
		return userRepository.save(createdUser);
	}

	@Override
	@Transactional
	public List<User> getByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	@Transactional
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=UserNotFound.class)
	public User delete(int id) throws UserNotFound {
		User deletedUser = userRepository.findOne(id);

		if (deletedUser == null)
			throw new UserNotFound();

		userRepository.delete(deletedUser);
		return deletedUser;
	}

	@Override
	@Transactional(rollbackFor=UserNotFound.class)
	public User update(User user) throws UserNotFound {
		User updatedUser = userRepository.findOne(user.getId());
		
		if (updatedUser == null)
			throw new UserNotFound();
		
		updatedUser.setName(user.getName());
		updatedUser.setAge(user.getAge());
		updatedUser.setIsAdmin(user.getIsAdmin());
		return updatedUser;
	}

}
