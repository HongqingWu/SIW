//package it.uniroma3.siw.galleria.validations;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import it.uniroma3.siw.galleria.model.Users;
//
//public class PasswordMatchesValidator 
//implements ConstraintValidator<PasswordMatch, Object> { 
//   
//  @Override
//  public void initialize(PasswordMatch constraintAnnotation) {       
//  }
//  @Override
//  public boolean isValid(Object obj, ConstraintValidatorContext context){   
//      Users user = (Users) obj;
//      return user.getPassword().equals(user.getMatchingPassword());    
//  }     
//}