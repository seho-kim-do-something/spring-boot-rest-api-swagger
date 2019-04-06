package com.seho.demo.restapiswagger.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.seho.demo.restapiswagger.entities.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

	Optional<Topic> findById(Integer id);
	
}
