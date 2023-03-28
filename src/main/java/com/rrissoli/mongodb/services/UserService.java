package com.rrissoli.mongodb.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrissoli.mongodb.domain.User;
import com.rrissoli.mongodb.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public List<User>  findAll(){
		return repo.findAll();	
	} 
}
