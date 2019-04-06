package com.seho.demo.restapiswagger.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Class representing a topic tracked by the application.")
public class TopicDTO {

	@NotNull
	@ApiModelProperty(notes = "Unique identifier of the topic. No two persons can have the same id.", required = true, readOnly=true, /*accessMode=AccessMode.READ_ONLY,*/ /*hidden=true,*/ position = 0)
	private Integer id;

	@NotBlank
	@ApiModelProperty(notes = "Name of the topic.", example = "Java 8 lambda basics", required = true, position = 1)
	private String name;

	@ApiModelProperty(notes = "Description of the topic.", example = "Learn java 8 lambda basics", required = true, position = 2)
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
