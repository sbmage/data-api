package com.sbmage.model;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

// @JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class User {
	
	private long userId;
	private String userName;
	private String password;
	private String logout = DateTime.now(DateTimeZone.forID("Asia/Seoul")).toString("yyyy-MM-dd HH:mm:ss");
	private String login = DateTime.now(DateTimeZone.forID("Asia/Seoul")).toString("yyyy-MM-dd HH:mm:ss");
	private String createDate = DateTime.now(DateTimeZone.forID("Asia/Seoul")).toString("yyyy-MM-dd HH:mm:ss");
	private String gameId = "";
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogout() {
		return logout;
	}
	public void setLogout(String logout) {
		this.logout = logout;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", logout=" + logout + ", login="
				+ login + ", createDate=" + createDate + ", gameId=" + gameId
				+ "]";
	}
	
}
