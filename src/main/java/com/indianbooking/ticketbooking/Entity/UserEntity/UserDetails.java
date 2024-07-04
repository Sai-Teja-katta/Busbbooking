package com.indianbooking.ticketbooking.Entity.UserEntity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "userdetails")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Pattern(regexp = "^[A-Za-z]{1,8}$",
			 message = "First name is required")
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Min(18)
	@Max(70)
	@Column(name = "age")
	private int age;
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE,
		   message = "Please enter valid mail Id")
	@Column(name = "email_id")
	private String emailid;

	@Column(name = "sex")
	private char sex;
	
	@Pattern(regexp = "^[A-Za-z0-9]{6,8}$", 
			message = "User Name Should be 6 to 8 digits")
	@Column(name = "user_name")
	private String userName;

	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+-=])(?=.{8,}$).*$", 
			 message = "password should meet conditions")
	@Column(name = "password")
	private String password;


	

}
