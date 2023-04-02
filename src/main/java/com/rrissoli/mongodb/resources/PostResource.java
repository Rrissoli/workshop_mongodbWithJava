package com.rrissoli.mongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrissoli.mongodb.domain.Post;
import com.rrissoli.mongodb.domain.User;
import com.rrissoli.mongodb.dto.AuthorDTO;
import com.rrissoli.mongodb.dto.UserDTO;
import com.rrissoli.mongodb.services.PostService;
import com.rrissoli.mongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class PostResource {
	
	
	
}
