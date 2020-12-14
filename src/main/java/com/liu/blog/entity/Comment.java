package com.liu.blog.entity;

public class Comment {

	private int commentId;
	private String commentContent;
	private String commentState;
	private String commentTime;
	private String title;
	private String userEmail;
	
	public Comment() {
		super();
	}

	public Comment(int commentId, String commentContent, String commentState, String commentTime, String title,
			String userEmail) {
		super();
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentState = commentState;
		this.commentTime = commentTime;
		this.title = title;
		this.userEmail = userEmail;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getCommentState() {
		return commentState;
	}

	public void setCommentState(String commentState) {
		this.commentState = commentState;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	
	
}
