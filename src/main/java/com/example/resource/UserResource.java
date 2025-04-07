package com.example.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.UserRequestDto;
import com.example.dto.UserResponseDto;
import com.example.entity.Address;
import com.example.entity.User;
import com.example.service.AddressService;
import com.example.service.UserService;

@Component
public class UserResource {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private ModelMapper modelMapper;

	public String addUser(UserRequestDto userRequestDto) {

		Address address = modelMapper.map(userRequestDto, Address.class);

		Address savedAddress = addressService.saveAddress(address);

		User user = modelMapper.map(userRequestDto, User.class);

		user.setAddress(savedAddress);

		User savedUser = userService.saveUser(user);

		if (savedUser != null) {
			return "User Saved SuccessFully..!" + user.getUserId();
		}

		return null;
	}

	public UserResponseDto getUserInfo(Integer id) {

		UserResponseDto userResponseDto = new UserResponseDto();

		User user = userService.getUserById(id);

		userResponseDto = modelMapper.map(user, UserResponseDto.class);

		Address address = user.getAddress();

		userResponseDto.setPincode(address.getPincode());
		userResponseDto.setAreaName(address.getAreaName());
		userResponseDto.setCityName(address.getCityName());
		userResponseDto.setStreet(address.getStreet());

		return userResponseDto;
	}

}
