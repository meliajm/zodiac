package com.revature.models;

import java.util.Arrays;
import java.util.Date;

public class UserDTO {

	public int userid;

	public String username;

	public String password;

	public String firstName;

	public String lastName;

	public Date dateOfBirth;

	public String description;

	public int gender;
	
	public byte[] picture;
	
	public Users u;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	public UserDTO(Users u) {
		this.u = u;
	}
	public UserDTO(int userid, String username, String password, String firstName, String lastName, Date dateOfBirth,
			String description, int gender, byte[] picture) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		this.gender = gender;
		this.picture = picture;
	}

	public UserDTO(String username, String password, String firstName, String lastName, Date dateOfBirth,
			String description, int gender, byte[] picture) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		this.gender = gender;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", description=" + description
				+ ", gender=" + gender + ", picture=" + Arrays.toString(picture) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + gender;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + Arrays.hashCode(picture);
		result = prime * result + userid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (!Arrays.equals(picture, other.picture))
			return false;
		if (userid != other.userid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
