package br.com.neri.pedro.orderpay.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.neri.pedro.orderpay.entities.User;
import br.com.neri.pedro.orderpay.repositories.UserRepository;
import br.com.neri.pedro.orderpay.services.exceptions.DataBaseException;
import br.com.neri.pedro.orderpay.services.exceptions.ResourceNotFoundException;

/**
 * Classe para servico
 * 
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
	 * Busca o usuario pelo Nome
	 * 
	 * @param name
	 * @return
	 */
	public User findByName(String name) {
		Optional<User> userName = userRepository.findByNameContaining(name);
		return userName.orElseThrow(() -> new ResourceNotFoundException(name));
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
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	/**
	 * @param id
	 * @param user
	 * @return
	 */
	public User update(Long id, User userContainingNewInfo) {
		try {
			User userToUpdate = userRepository.getOne(id);
			updateData(userToUpdate, userContainingNewInfo);
			return userRepository.save(userToUpdate);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

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
