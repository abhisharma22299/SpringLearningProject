package com.SmartContactManager.SmartContactManagerSpring.HomeController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SmartContactManager.Helper.Message;
import com.SmartContactManager.SmartContactManagerSpring.Entites.Contact;
import com.SmartContactManager.SmartContactManagerSpring.Entites.User;
import com.SmartContactManager.SmartContactManagerSpring.dao.ContactRepository;
import com.SmartContactManager.SmartContactManagerSpring.dao.UserRepository;




@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private ContactRepository contactRepository;
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
String name=principal.getName();
User user =this.userRepository.getUserByUserName(name);
contact.setUser(user);
user.getContacts().add(contact);
if(file.isEmpty()) {
System.out.println("Img not selected");
System.out.println();
contact.setImage("contact.JPG");

	//error messaging
	System.out.println("Image not uploaded");
	session.setAttribute("message", new Message("Your Contact is Added Successfully ! Add More","success"));
}else {
	
	
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
session.setAttribute("message", new Message("Your Contact is Added Successfully ! Add More","success"));
}
this.userRepository.save(user);		
System.out.println("DATA"+contact);
System.out.println("Added to data base in contact filed");
	}catch(Exception e) {
		System.out.println();
		System.out.println("catch box bocj in pricessing image");
		System.out.println();
	System.out.println("Error"+e.getMessage());	
	e.printStackTrace();
	//message for not success
session.setAttribute("message", new Message("Something went wrong! Add Again",
				"danger"));
		
	}

return "normal/add_contact_form";
}

// show contacts handler
// apply pagination 10[n]
@GetMapping("/show-contact")
public String showContact(Model model,Principal principal) {

		model.addAttribute("tittle", "Show-Contacts");
	String UserName =principal.getName();
	User user=this.userRepository.getUserByUserName(UserName);
	int userIdDetails=user.getId();
	
	List<Contact> contacts=this.contactRepository.findContactByUser(user.getId());
	
	model.addAttribute("contacts",contacts);
	System.out.println("THIS IS USER SHOW CONTACTS");
	
	return "normal/show_contact";	
}


// showing specfic contact details
//@RequestMapping("/{CId}/contact}")
//public String showContactDetails(@PathVariable("CId") Integer CId) {
//	System.out.println("CId"+CId);
//	
//	return"normal/contact_details";
//}
@RequestMapping("/{CId}/contact")
public String showContactDetailsSpecficUser(@PathVariable("CId") Integer CId ,Model models){
	
	
 Optional<Contact> contactOptional=	this.contactRepository.findById(CId);
 Contact contact=contactOptional.get();
 models.addAttribute("contact", contact);
 return "normal/contact_details";
	
}





}
