package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

/**
 * @author pedro.neri
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRep;

	/**
	 * @return
	 */
	public List<User> findAll() {
		return userRep.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	public User findById(Long id) {
		Optional<User> optionalUser = userRep.findById(id);
		return optionalUser.get();
	}

	/**
	 * @param user
	 * @return
	 */
	public User insert(User user) {
		return userRep.save(user);

	}

	/**
	 * @param id
	 */
	public void delete(Long id) {
		userRep.deleteById(id);
	}

	/**
	 * @param id
	 * @param user
	 * @return
	 */
	public User update(Long id, User user) {

		User entity = userRep.getOne(id);
		updateData(entity, user);
		return userRep.save(user);

	}

	/**
	 * @param entity
	 * @param user
	 */
	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());

	}

}
