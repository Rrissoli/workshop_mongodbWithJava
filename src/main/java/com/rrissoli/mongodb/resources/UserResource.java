package com.rrissoli.mongodb.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rrissoli.mongodb.domain.Post;
import com.rrissoli.mongodb.domain.User;
import com.rrissoli.mongodb.dto.UserDTO;
import com.rrissoli.mongodb.services.UserService;
import com.rrissoli.mongodb.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	@GetMapping
	public ResponseEntity<List<UserDTO>>  findAll(){
		List<User>list  = service.findAll();
		List <UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO>  findById(@PathVariable String id){
		try {
			User user = service.findById(id);
			UserDTO userDto = new UserDTO(user);
			return ResponseEntity.ok().body(userDto);
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Not found object with id = " + id);
		}
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>  insert(@RequestBody UserDTO objDto){
			User user = service.fromDTO(objDto);
			user = service.insert(user);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>  deleteById(@PathVariable String id){
		try {
			service.delete(id);
			return ResponseEntity.noContent().build();
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Not found object with id = " + id);
		}
	}
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void>  update(@PathVariable String id , @RequestBody UserDTO objDto){
		try {
			User obj = service.fromDTO(objDto);
			obj.setId(id);
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Not found object with id = " + id);
		}
	}
	@RequestMapping(value="/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>>  findPosts(@PathVariable String id ){
		try {
			User user = service.findById(id);
			
			return ResponseEntity.ok().body(user.getPosts());
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Not found object with id = " + id);
		}
	}
}
