package com.seho.demo.restapiswagger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seho.demo.restapiswagger.dtos.TopicDTO;
import com.seho.demo.restapiswagger.entities.Topic;
import com.seho.demo.restapiswagger.mappers.TopicMapper;
import com.seho.demo.restapiswagger.repositories.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private TopicMapper mapper;
	
	public List<TopicDTO> getAllTopics() throws Throwable {
		List<Topic> topics = (List<Topic>) topicRepository.findAll();
		return mapper.bindList(topics);
	}

	public TopicDTO getTopic(Integer id) throws Throwable {
		Topic topic = topicRepository.findById(id).get();
		return mapper.bindDTO(topic);
	}

	public TopicDTO createTopic(TopicDTO topicDTO) throws Throwable {
		Topic topic = new Topic();
		mapper.updateEntity(topicDTO, topic);
		Topic topicCreated = topicRepository.save(topic);		
		return mapper.bindDTO(topicCreated);
	}
	
	public TopicDTO updateTopic(Integer id, TopicDTO topicDTO) throws Throwable {
		Topic topic = topicRepository.findById(id).get();
		if(topic == null) {
			return null;
		}
		mapper.updateEntity(topicDTO, topic);
		Topic topicUpdated = topicRepository.save(topic);		
		return mapper.bindDTO(topicUpdated);
	}

	public void deleteTopic(Integer id) {
		Topic topic = topicRepository.findById(id).get();
		topicRepository.delete(topic);
	}
	
}
