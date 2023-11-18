package com.WebApplication.WebApplication;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	
	@RequestMapping(value="/about",method= RequestMethod.GET)
	public String about(Model model) {
			
			
		model.addAttribute("name","Abhishek Sharma");
		model.addAttribute("currentDate",new Date().toString());
		return "about";
	}
	
	
	@GetMapping("/exampleLoop")
public String itrateHandler(Model model) {
	List<String > names=List.of("abhishek ","Sharma ");
	model.addAttribute("names", names);
	return "iterate";
}
	
	
// conditional statements 
	
	@GetMapping("/cond")
	public String conditonals(Model models)
	{
		models.addAttribute("isActive ",false);
		models.addAttribute("gender", "F");
		
		List<Integer> numberss = List.of(10,12,30);
		models.addAttribute("numbers", numberss);
		return "cond";
		
	}
	@GetMapping("/service")
	public String service()

	{
		
		
		
		return "service";
	}

	@GetMapping("/aboutNew")
	public String services()

	{
		
		
		
		return "aboutNew";
	}


	
	@GetMapping("/contact")
	public String servicess()

	{
		
		
		
		return "contact";
	}
	
	
	
	// validation form 


//	@PostMapping("/aprocess")
//public String openFromsss(@ModelAttribute("LoginData") LoginData LoginData) {
//	
//	System.out.println(LoginData);
//	return "success";
//	
//}

@PostMapping("/process")
public String test(@Valid @ModelAttribute("loginData")LoginData loginData,BindingResult result) {

	if(result.hasErrors()) {
		System.out.println(result);
	}
	System.out.println(loginData);

	return "result";
}
@GetMapping("/form")
public String doopenFroms(Model models) {
    System.out.println("opening form ");	
	models.addAttribute("loginData", new LoginData());
	return "form";
	
}

}







