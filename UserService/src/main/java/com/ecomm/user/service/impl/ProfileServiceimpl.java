package com.ecomm.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.ecomm.user.dto.ProfileDto;
import com.ecomm.user.entity.Profile;
import com.ecomm.user.exception.AppException;
import com.ecomm.user.repository.ProfileRepo;
import com.ecomm.user.request.ProfileUpdateRequest;
import com.ecomm.user.respone.CloudinaryResponse;
import com.ecomm.user.service.CloudinaryService;
import com.ecomm.user.service.ProfileService;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class ProfileServiceimpl implements ProfileService {
	@Autowired
	private ProfileRepo prepo;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CloudinaryService cservice;
	
	

	@Override
	public Profile addprofile(Profile profile) {
		return prepo.save(profile);
	}

	@Override
	public void deleteprofile(Integer profileId) {
		
		prepo.findById(profileId).orElseThrow(()->new AppException("user not found", HttpStatus.NOT_FOUND));
		prepo.deleteById(profileId);

	}

	@Override
	public ProfileDto getByprofileId(Integer profileId) {
		// TODO Auto-generated method stub
		Profile p=prepo.findById(profileId).orElseThrow(()->new AppException("User not Found", HttpStatus.NOT_FOUND));
		 ProfileDto pdto=mapper.map(p, ProfileDto.class);
		return pdto;
	}

	@Override
	public ProfileDto getProfileByUserId(Integer userId) {
		// TODO Auto-generated method stub
		
		Profile p=prepo.findByUserUserId(userId).orElseThrow(()-> new  AppException("user not found", HttpStatus.NOT_FOUND));
		ProfileDto pdto= mapper.map(p, ProfileDto.class);
		return pdto;
	}

	@Override
	public ProfileDto updateProfile(Integer profileId, ProfileUpdateRequest request, MultipartFile image) {
		Profile p=prepo.findById(profileId).orElseThrow(()->new AppException("Profile not found!", HttpStatus.NOT_FOUND));
		mapper.map(request, p);
		//image uploading
		if(image!=null&&!image.isEmpty()) {
			if(p.getImageUrl()!=null&&p.getPublicUrl()!=null) {
				cservice.deleteImage(p.getPublicUrl());
			}
			CloudinaryResponse response=cservice.uploadImage(image);
			p.setImageUrl(response.getImageUrl());
			p.setPublicUrl(response.getPublicId());
		}
		p=prepo.save(p);
		return mapper.map(p, ProfileDto.class);
	}

}
