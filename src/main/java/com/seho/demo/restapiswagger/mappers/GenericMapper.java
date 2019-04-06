package com.seho.demo.restapiswagger.mappers;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.google.common.collect.Lists;

public abstract class GenericMapper<ENTITY, DTO> {

	protected DozerBeanMapper beanMapper = new DozerBeanMapper();

	protected Class<ENTITY> entityClazz;

	protected Class<DTO> dtoClazz;

	@SuppressWarnings("unchecked")
	GenericMapper() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClazz = (Class<ENTITY>) type.getActualTypeArguments()[0];
		dtoClazz = (Class<DTO>) type.getActualTypeArguments()[1];
	}

	public DTO bindDTO(ENTITY entity) throws Throwable {
		if(entity != null) {
			return beanMapper.map(entity, dtoClazz);
		}
		return null;
	}

	public void updateEntity(DTO dto, ENTITY entity) throws Throwable {
		beanMapper.map(dto, entity);
	}

	public List<DTO> bindList(Iterable<ENTITY> sourceList) throws Throwable {
		List<DTO> destinationList = Lists.newArrayList();
		for (ENTITY sourceObject : sourceList) {
			DTO destinationObject = bindDTO(sourceObject);
			if(destinationObject != null) {
				destinationList.add(destinationObject);
			}
		}		
		return destinationList;
	}
}
