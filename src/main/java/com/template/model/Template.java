package com.template.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "templates")
public class Template {

	private long id;
	private String templateCharacteristic;

	public Template() {
  
    }
 

	public Template(String templateCharacteristic) {
		this.templateCharacteristic = templateCharacteristic;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

	@Column(name = "template", nullable = false)
    public String getTemplateCharacteristic() {
        return templateCharacteristic;
    }
	public void setTemplateCharacteristic(String templateCharacteristic) {
		this.templateCharacteristic = templateCharacteristic;
	}
	
	@Override
    public String toString() {
        return "Template [id=" + id + ", template=" + templateCharacteristic + "]";
    }
}
