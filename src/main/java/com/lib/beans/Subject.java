package com.lib.beans;


public class Subject {

	private int subjectId;
	private String subjectTitle;
	private int duration;
	private int bookId;
	
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
				", Duration in Hrs : " + this.duration + ", Books : " + this.bookId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}
