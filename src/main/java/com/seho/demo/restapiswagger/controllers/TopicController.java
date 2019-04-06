package com.seho.demo.restapiswagger.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seho.demo.restapiswagger.dtos.TopicDTO;
import com.seho.demo.restapiswagger.services.TopicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v2/")
@Api(tags = { "Topic Resource" }, produces = MediaType.APPLICATION_JSON_VALUE)
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	private Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	@GetMapping("/topics")
	@ApiOperation("Returns list of all Topics in the system.")
	public List<TopicDTO> getAllTopics() throws Throwable {
		logger.info("getting all topics");
		return topicService.getAllTopics();
	}
	
	@GetMapping("/topics/{id}")
	@ApiOperation("Returns a specific topic by id. 404 if does not exist.")
	public ResponseEntity<TopicDTO> getTopic(@PathVariable Integer id) throws Throwable {
		TopicDTO topicDTO = topicService.getTopic(id);
		if(topicDTO == null) {
			logger.warn("topic [id: {}] not found", id);
			return new ResponseEntity<TopicDTO>(HttpStatus.NOT_FOUND);
		}
		logger.info("getting the topic [id: {}]", id);
		return new ResponseEntity<TopicDTO>(topicDTO, HttpStatus.OK);
	}
	
	@PostMapping("/topics")
	@ApiOperation("Creates a new topic.")
	public ResponseEntity<TopicDTO> addTopic(@RequestBody TopicDTO topicDTO) throws Throwable {
		logger.info("creating a new topic");
		TopicDTO createdTopicDTO = topicService.createTopic(topicDTO);
		return new ResponseEntity<TopicDTO>(createdTopicDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/topics/{id}")
	@ApiOperation("Edit a topic from the system. 404 if the topic's id is not found.")
	public ResponseEntity<TopicDTO> updateTopic(@RequestBody TopicDTO topicDTO, @PathVariable Integer id) throws Throwable {
		TopicDTO updatedTopicDTO = topicService.updateTopic(id, topicDTO);
		if(updatedTopicDTO == null) {
			logger.warn("topic [id: {}] not found", id);
			return new ResponseEntity<TopicDTO>(HttpStatus.NOT_FOUND);
		}
		logger.info("updating the topic [id: {}]", id);
		return new ResponseEntity<TopicDTO>(updatedTopicDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/topics/{id}")
	@ApiOperation("Deletes a topic from the system.")
	public void deleteTopic(@PathVariable Integer id) {
		logger.info("deleting the topic [id: {}]", id);
		topicService.deleteTopic(id);
	}
}
