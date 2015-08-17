package com.spr.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spr.model.User;

@Component
public class UserValidator implements Validator {
	
	private final static String AGE = "age";

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		Integer age = user.getAge();
		
		ValidationUtils.rejectIfEmpty(errors, "name", "user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, AGE, "user.age.empty");

		if(user.getName().length()>40)
			errors.rejectValue(AGE, "user.name.long");
		if ((age != null && age < 1)||(age != null&&age>200))
			errors.rejectValue(AGE, "user.age.lessThenOne");

	}

}
