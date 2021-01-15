package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

/**
 * @author pedro.neri
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	private User updateData;

	/**
	 * @return
	 */
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	/**
	 * @param user
	 * @return
	 */
	public User insert(User user) {
		return userRepository.save(user);

	}

	/**
	 * @param id
	 */
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	/**
	 * @param id
	 * @param user
	 * @return
	 */
	public User update(Long id, User userContainingNewInfo) {
		User userToUpdate = userRepository.getOne(id);
		updateData(userToUpdate, userContainingNewInfo);
		return userRepository.save(userToUpdate);

	}

	/**
	 * @param entity
	 * @param user
	 */
	private void updateData(User userToUpdate, User userWhithNewInfos) {
		if (userWhithNewInfos.getName() != null) {
			userToUpdate.setName(userWhithNewInfos.getName());
		}
		if (userWhithNewInfos.getEmail() != null) {
			userToUpdate.setEmail(userWhithNewInfos.getEmail());

		}
		if (userWhithNewInfos.getPhone() != null) {
			userToUpdate.setPhone(userWhithNewInfos.getPhone());
		}

	}

}
