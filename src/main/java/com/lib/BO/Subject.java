package com.lib.BO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT")
public class Subject {

	@Id
	@Column(name = "SUBJECT_ID", nullable=false, unique=true)
	private int subjectId;
	
	@Column(name = "SUB_TITLE", nullable=true, unique=false)
	private String subjectTitle;
	
	@Column(name = "DURATION_IN_HRS", nullable=true, unique=false)
	private int duration;
	
	@Column(name = "REC_CREATED_DATE", nullable=true, unique=false)
	private Date recordCreated = new Date();
	
	@Column(name = "REC_MODIFIED_DATE", nullable=true, unique=false)
	private Date recordModified = new Date();
	
	public Subject(int subId, String subTitle, int duration) {
		this.subjectId = subId;
		this.subjectTitle = subTitle;
		this.duration = duration;
	}
	
	public Subject() {
		//default
	}

	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Subject Id : " + this.subjectId + ", Subject Title : " + this.subjectTitle +
				", Duration in Hrs : " + this.duration;
	}
	
	public Date getRecordCreated() {
		return recordCreated;
	}
	public void setRecordCreated() {
		this.recordCreated = new Date();
	}
	public Date getRecordModified() {
		return recordModified;
	}
	public void setRecordModified(Date recordModified) {
		this.recordModified = recordModified;
	}
}
