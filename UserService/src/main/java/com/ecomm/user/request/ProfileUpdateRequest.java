package com.ecomm.user.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateRequest {

	private String firstName;
	
	private String lastName;
	
	private LocalDate dob;
	
	private String phone;
}
