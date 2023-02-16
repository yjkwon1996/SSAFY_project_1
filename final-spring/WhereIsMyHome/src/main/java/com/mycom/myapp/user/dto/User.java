package com.mycom.myapp.user.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class User {
	
	@Id @GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String userEmail;

	private String userPassword;

	private String userName;

	private LocalDate userRegisterDate;

	private boolean isLoggedIn;

	private boolean isAdmin;

	private String userProfileImageUrl;
}
