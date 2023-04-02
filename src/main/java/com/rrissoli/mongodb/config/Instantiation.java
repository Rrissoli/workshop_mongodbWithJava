package com.rrissoli.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rrissoli.mongodb.domain.Post;
import com.rrissoli.mongodb.domain.User;
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
		Post post1 = new Post(null, sdt.parse("21/03/2021"),"partiu viagem", "que legal", maria );
		Post post2 = new Post(null, sdt.parse("02/06/2023"),"loucura lourcura", "seja bem vindo", maria );
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
