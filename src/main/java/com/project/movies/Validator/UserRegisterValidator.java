package com.project.movies.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.project.movies.pojos.User;


public class UserRegisterValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz) {
		//This Validator validates *just* User instances
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//basic validations
		System.out.println("in validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty.name", "Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty.username", "User Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Password is Required");
		System.out.println(errors);
		//add additional custom validations below
		System.out.println(" validator works");
	}
}
