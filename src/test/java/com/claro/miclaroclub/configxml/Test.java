package com.claro.miclaroclub.configxml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Test {
	
	@XmlAttribute
	private String name;
	@XmlElement(name= "parameter")
	private List<Parameter> params;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Parameter> getParams() {
		return params;
	}
	public void setParams(List<Parameter> params) {
		this.params = params;
	}
	
	
	

}
