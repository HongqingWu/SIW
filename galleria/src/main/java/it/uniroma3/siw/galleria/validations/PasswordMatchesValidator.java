package it.uniroma3.siw.galleria.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import it.uniroma3.siw.galleria.model.UserDto;

public class PasswordMatchesValidator 
implements ConstraintValidator<PasswordMatch, Object> { 
   
  @Override
  public void initialize(PasswordMatch constraintAnnotation) {       
  }
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){   
      UserDto user = (UserDto) obj;
      return user.getPassword().equals(user.getMatchingPassword());    
  }     
}