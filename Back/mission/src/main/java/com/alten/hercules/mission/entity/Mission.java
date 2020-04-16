package com.alten.hercules.mission.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Mission {
	//TODO contraintes tailles
	@Id
	private long id;
	
	private String title;
	@Length(max = 1000)
	private String description;
	@Enumerated(EnumType.STRING)
	private ETypeMission type;
	private String city;
	private String comment;
	private String consultantRole;
	private String consultantExperience;
	@Enumerated(EnumType.STRING)
	private EState state;
	int teamSize;
	
	private long consultantId;
	private long customerId;
	
	
	
}
