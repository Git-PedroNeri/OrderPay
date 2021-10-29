package br.com.neri.pedro.orderpay.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.neri.pedro.orderpay.dto.UserDTO;
import br.com.neri.pedro.orderpay.entities.User;
import br.com.neri.pedro.orderpay.repositories.UserRepository;
import br.com.neri.pedro.orderpay.services.UserService;

@RestController
@RequestMapping(value = "/users") // EndPoint
public class UserResource {

	@Autowired
	private UserService userService;
	@Autowired
	UserRepository repositorio;

	private ModelMapper modelMapper;

	public UserResource(UserService userService, ModelMapper modelMapper) {
		super();
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

	/**
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> users = userService.findAll();
		List<UserDTO> usersDtos = users.stream().map(user -> modelMapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(usersDtos);
	}

	/**
	 * End point que retorna um usuario passando o id como paramentro
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);

	}

	@GetMapping(value = "/modelmapper/{usuarioId}")
	public ResponseEntity<UserDTO> buscarById(@PathVariable Long usuarioId) {

		return repositorio.findById(usuarioId).map(usuario -> {
			UserDTO userDTO = modelMapper.map(usuario, UserDTO.class);
			return ResponseEntity.ok(userDTO);
		}).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping(value = "/nome/{nome}")
	public ResponseEntity<UserDTO> buscarPeloNome(@PathVariable String nome) {
		UserDTO userDTO = modelMapper.map(userService.findByName(nome), UserDTO.class);
		return ResponseEntity.ok().body(userDTO);
	}

	/**
	 * @param obj
	 * @return
	 */
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		user = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User userContainingNewInfo) {
		userContainingNewInfo = userService.update(id, userContainingNewInfo);
		return ResponseEntity.ok(userContainingNewInfo);

	}

}
