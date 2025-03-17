package com.itatechserviceweb.prototipo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itatechserviceweb.prototipo.entities.User;
import com.itatechserviceweb.prototipo.repositories.UserRepository;
import com.itatechserviceweb.prototipo.services.exceptions.DatabaseException;
import com.itatechserviceweb.prototipo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (BeanInstantiationException e) {
			throw new ResourceNotFoundException(id);
		}
		
		catch (UnsatisfiedDependencyException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}	
		
		catch (BeanCreationException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}	
		
		catch (RuntimeException e) {
			throw new DatabaseException(e.getMessage());
		}	
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
