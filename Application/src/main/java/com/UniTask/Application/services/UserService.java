package com.UniTask.Application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UniTask.Application.model.User;
import com.UniTask.Application.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private	UserRepository repository;
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);	// retorna obj salvo.
	}
	
	public void delete(Long id) {
		repository.deleteById(id);	// Está sem tratamento de try catch por hora, apenas para demonstrar requisição.
	}
	
	public User update(Long id, User obj) {
		User entity = findById(id);
		entity.setName(obj.getName());
		entity.setMail(obj.getMail());
		entity.setPassword(obj.getPassword());
		return repository.save(entity);
	}
}
