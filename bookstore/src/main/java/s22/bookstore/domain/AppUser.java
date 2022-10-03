package s22.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUser {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String fname, lname;
private String role;

@Column(name = "username", nullable = false, unique = true)
private String username;

@Column(name = "password", nullable = false)
private String passwordHash;

public AppUser() {
	super();
	// TODO Auto-generated constructor stub
}

public AppUser(String fname, String lname, String role, String username, String passwordHash) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.role = role;
	this.username = username;
	this.passwordHash = passwordHash;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPasswordHash() {
	return passwordHash;
}

public void setPasswordHash(String passwordHash) {
	this.passwordHash = passwordHash;
}

@Override
public String toString() {
	return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", role=" + role + ", username="
			+ username + ", passwordHash=" + passwordHash + "]";
}



}
