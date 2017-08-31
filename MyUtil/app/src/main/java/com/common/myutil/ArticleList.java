package com.common.myutil;


public class ArticleList {
	private String title;
	private String content;
	private String time;
	private String courseid;
	private String sentenceid;
	private String sentenceSrc;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getTime() {
		return time;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setSentenceid(String sentenceid) {
		this.sentenceid = sentenceid;
	}

	public String getSentenceid() {
		return sentenceid;
	}

	public void setSentenceSrc(String sentenceSrc) {
		this.sentenceSrc = sentenceSrc;
	}

	public String setSentenceSrc() {
		return sentenceSrc;
	}

}
