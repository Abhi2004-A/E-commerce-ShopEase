package com.ecomm.user.service;

import org.springframework.web.multipart.MultipartFile;

import com.ecomm.user.dto.ProfileDto;
import com.ecomm.user.entity.Profile;
import com.ecomm.user.request.ProfileUpdateRequest;

public interface ProfileService {
	
	Profile addprofile(Profile profile);
	
	ProfileDto updateProfile(Integer profileId, ProfileUpdateRequest request, MultipartFile image);
	
	void deleteprofile(Integer profileId);
	
	ProfileDto getByprofileId(Integer profileId);
	
	ProfileDto getProfileByUserId(Integer userId);
	
	
	

	
}
