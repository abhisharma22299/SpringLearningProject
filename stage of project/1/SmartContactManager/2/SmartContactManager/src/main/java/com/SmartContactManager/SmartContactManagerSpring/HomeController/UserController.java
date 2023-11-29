package com.SmartContactManager.SmartContactManagerSpring.HomeController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SmartContactManager.Helper.Message;
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
public String processContact(@ModelAttribute Contact contact,
		@RequestParam("profileImage") MultipartFile file,Principal principal,
		HttpSession session) {
	
	
	try {
		System.out.println();
		System.out.println("Try Block");
		System.out.println();
		String name =principal.getName();
		User user =this.userRepository.getUserByUserName(name);

		//processing and handling file or uploading file
		if(file.isEmpty()) {
			if(3>2) {
				throw new Exception();
			}
			//error messaging
			System.out.println("Image not uploaded");
		}
		else {
			//uploading file
			System.out.println();
			System.out.println("Else bocj in pricessing image");
			System.out.println();
			contact.setImage(file.getOriginalFilename());
			File saveFile=new ClassPathResource("static/img").getFile();
			Path path=Paths.get(saveFile.getAbsolutePath()+File.
					separator+file.getOriginalFilename());
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Image uploaded");
		}
user.getContacts().add(contact);
this.userRepository.save(user);
System.out.println("ADDED data");

// message success full
session.setAttribute("message", new Message("Your Contact added succesfully ! Add more",
		"success"));
}
catch(Exception e) {
	
	System.out.println();
	System.out.println("catch box bocj in pricessing image");
	System.out.println();
System.out.println("Error"+e.getMessage());	
e.printStackTrace();
//message for not success
	session.setAttribute("message", new Message("Something went wrong! Add Again" ,
			"danger"));
}
return "normal/add_contact_form";
}

// show contacts handler
@GetMapping("/show-contact")
public String showContact(Model model) {
	return "show-contact";	
}







}
