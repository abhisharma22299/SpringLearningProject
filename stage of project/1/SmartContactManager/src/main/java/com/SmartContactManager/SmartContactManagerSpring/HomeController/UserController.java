package com.SmartContactManager.SmartContactManagerSpring.HomeController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SmartContactManager.SmartContactManagerSpring.Entites.Contact;
import com.SmartContactManager.SmartContactManagerSpring.Entites.User;
import com.SmartContactManager.SmartContactManagerSpring.dao.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@ModelAttribute
	public void  addCommonData( Model models,Principal principal){
		String userName=principal.getName();
		System.out.println("USERNAME"+ userName);
	User user=	userRepository.getUserByUserName(userName);
	System.out.println("USER"+user);
		models.addAttribute("user", user);

	}
@RequestMapping("/index")
	public String dashBoard(Model models,Principal principal) {
	
		return "normal/user_dashboard";
	}

@GetMapping("/add-contact")
public String openAddContact(Model models) {
		models.addAttribute("tittle", "Add-Contact");
		models.addAttribute("contact", new Contact());

		return "normal/add_contact_form";
}



@PostMapping("/process-contact")
public String processContact
(@ModelAttribute Contact contact ,Principal principal) {
String name =principal.getName()	;
User user =this.userRepository.getUserByUserName(name);
user.getContacts().add(contact);
this.userRepository.save(user);
System.out.println("ADDED data");
return "normal/add_contact_form";
}
}
