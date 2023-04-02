package com.rrissoli.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrissoli.mongodb.domain.Post;
import com.rrissoli.mongodb.repository.PostRepository;
import com.rrissoli.mongodb.services.exceptions.ObjectNotFoundException;
@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public List<Post>  findAll(){
		return repo.findAll();	
	} 
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	public Post insert(Post obj) {
		return repo.insert(obj);
	}
//	public void delete(String id) {
//		findById(id);
//		repo.deleteById(id);
//	}
	
	}

