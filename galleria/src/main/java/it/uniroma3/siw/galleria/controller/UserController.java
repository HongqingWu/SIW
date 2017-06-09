package it.uniroma3.siw.galleria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.galleria.model.UserDto;
import it.uniroma3.siw.galleria.service.UserService;
import it.uniroma3.siw.galleria.model.User;

@Controller
public class UserController {
	@Autowired
    private UserService userService; 

    @GetMapping("/userDto")
    public String showForm(UserDto userDto) {
        return "form";
    }

    @PostMapping("/userDto")
    public String checkCustomerInfo(@Valid @ModelAttribute UserDto userDto, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
        	
        }
        return "results";
    }
}
