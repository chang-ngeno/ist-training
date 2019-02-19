package com.validator;

import com.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(
			errors,
			"firstName",
			"error.firstName",
			"First name is required."
		);

		ValidationUtils.rejectIfEmptyOrWhitespace(
			errors,
			"lastName",
			"error.lastName",
			"Last name is required."
		);

		ValidationUtils.rejectIfEmptyOrWhitespace(
			errors,
			"email",
			"error.email",
			"Email is required."
		);
	}
}
