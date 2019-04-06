package com.seho.demo.restapiswagger.mappers;

import org.springframework.stereotype.Component;

import com.seho.demo.restapiswagger.dtos.TopicDTO;
import com.seho.demo.restapiswagger.entities.Topic;

@Component
public class TopicMapper extends GenericMapper<Topic, TopicDTO> {

	@Override
	public void updateEntity(TopicDTO dto, Topic entity) throws Throwable {
		super.updateEntity(dto, entity);
		entity.setInternalProperty(0);
	}
	
	
	
}
