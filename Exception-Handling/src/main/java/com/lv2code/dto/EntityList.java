package com.lv2code.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({PlanDTO.class})
public class EntityList<T> {
	
	private List<T> listOfEntityObjects;
	
	public EntityList() {
		listOfEntityObjects = new ArrayList<>();
	}
	
	public EntityList(List<T> listOfEntityObjects) {
		this.listOfEntityObjects = listOfEntityObjects;
	}
	
	public List<T> getItems() {
		return listOfEntityObjects;
	}
	
}
