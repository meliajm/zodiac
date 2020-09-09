package com.revature.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	private int followerid;
	@Column(nullable=false, unique=true)
	private String username;
	@Column(nullable=false)
	private int password;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	@Column(nullable=false)
	private Date dateOfBirth;
	@Column(length=250)
	private String description;
	@Column(nullable=false)
	private int gender;
	private byte[] picture;
	@ManyToMany
	@JoinTable(name="user_follower",
	 joinColumns=@JoinColumn(name="userid"),
	 inverseJoinColumns=@JoinColumn(name="followerid")
	)
	private List<User> followers;
	
	@ManyToMany
	@JoinTable(name="user_follower",
	 joinColumns=@JoinColumn(name="followerid"),
	 inverseJoinColumns=@JoinColumn(name="userid")
	)
	private List<User> followees;

	public int getFollowerid() {
		return followerid;
	}

	public void setFollowerid(int followerid) {
		this.followerid = followerid;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	public List<User> getFollowees() {
		return followees;
	}

	public void setFollowees(List<User> followees) {
		this.followees = followees;
	}

	
	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(int userid, int followerid, String username, int password, String firstName, String lastName,
			Date dateOfBirth, String description, int gender, byte[] picture) {
		super();
		this.userid = userid;
		this.followerid = followerid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		this.gender = gender;
		this.picture = picture;
	}

	public User(int userid, int followerid, String username, int password, String firstName, String lastName,
			Date dateOfBirth, String description, int gender, byte[] picture, List<User> followers,
			List<User> followees) {
		super();
		this.userid = userid;
		this.followerid = followerid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		this.gender = gender;
		this.picture = picture;
		this.followers = followers;
		this.followees = followees;
	}
	
	

	public User(String username, int password, String firstName, String lastName, Date dateOfBirth, String description,
			int gender, byte[] picture, List<User> followers, List<User> followees) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		this.gender = gender;
		this.picture = picture;
		this.followers = followers;
		this.followees = followees;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", followerid=" + followerid + ", username=" + username + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", description=" + description + ", gender=" + gender + ", picture=" + Arrays.toString(picture)
				+ ", followers=" + followers + ", followees=" + followees + "]";
	}
	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((followees == null) ? 0 : followees.hashCode());
		result = prime * result + followerid;
		result = prime * result + ((followers == null) ? 0 : followers.hashCode());
		result = prime * result + gender;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + password;
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
		User other = (User) obj;
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
		if (followees == null) {
			if (other.followees != null)
				return false;
		} else if (!followees.equals(other.followees))
			return false;
		if (followerid != other.followerid)
			return false;
		if (followers == null) {
			if (other.followers != null)
				return false;
		} else if (!followers.equals(other.followers))
			return false;
		if (gender != other.gender)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password != other.password)
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
