package com.rrissoli.mongodb.config;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rrissoli.mongodb.domain.Post;
import com.rrissoli.mongodb.domain.User;
import com.rrissoli.mongodb.dto.AuthorDTO;
import com.rrissoli.mongodb.dto.CommentDTO;
import com.rrissoli.mongodb.repository.PostRepository;
import com.rrissoli.mongodb.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdt = new  SimpleDateFormat("dd/MM/yyy");
		sdt.setTimeZone(TimeZone.getTimeZone("GMT"));
		// TODO Auto-generated method stub
		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		Post post1 = new Post(null, sdt.parse("21/03/2021"),"partiu viagem", "que legal", new AuthorDTO(maria) );
		Post post2 = new Post(null, sdt.parse("02/06/2023"),"loucura lourcura", "seja bem vindo", new AuthorDTO(maria) );
		postRepository.saveAll(Arrays.asList(post1,post2));
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		CommentDTO comentario1 = new CommentDTO("caralho que doido",sdt.parse("21/03/2021"), new AuthorDTO(alex));
		CommentDTO comentario2 = new CommentDTO("ciuuuppaa", sdt.parse("21/03/2021"), new AuthorDTO(bob));
		CommentDTO comentario3 = new CommentDTO("1234232456345", sdt.parse("21/03/2021"), new AuthorDTO(maria));
		post1.getComentaries().addAll(Arrays.asList(comentario1,comentario2,comentario3));
		postRepository.save(post1);
	}

}
