package com.alten.hercules.consultant.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Consultant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String email;
	private String firstname;
	private String lastname;
	private String formation;
	private String school;
	private String experience;
	private boolean isEnabled;
	private int idManager;
	private Date deactivationDate;
	
	
	
	public Consultant(int id, @NotNull String email, String firstname, String lastname, String formation, String school,
			String experience, boolean isEnabled, int idManager, Date deactivationDate) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.formation = formation;
		this.school = school;
		this.experience = experience;
		this.isEnabled = isEnabled;
		this.idManager = idManager;
		this.deactivationDate = deactivationDate;
	}

	public Consultant() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public int getIdManager() {
		return idManager;
	}

	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	public Date getDeactivationDate() {
		return deactivationDate;
	}

	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	@Override
	public String toString() {
		return "Consultant [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", formation=" + formation + ", school=" + school + ", experience=" + experience + ", isEnabled="
				+ isEnabled + ", idManager=" + idManager + "]";
	}
	
	
	
	
	
}
