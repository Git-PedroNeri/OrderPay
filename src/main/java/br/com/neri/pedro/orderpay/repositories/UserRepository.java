package br.com.neri.pedro.orderpay.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.neri.pedro.orderpay.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByNameContaining(String name);

}
