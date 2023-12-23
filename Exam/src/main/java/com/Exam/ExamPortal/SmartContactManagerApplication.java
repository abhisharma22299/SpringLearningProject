package com.Exam.ExamPortal;

import com.Exam.ExamPortal.Modelss.Role;
import com.Exam.ExamPortal.Modelss.User;
import com.Exam.ExamPortal.Modelss.UserRole;
import com.Exam.ExamPortal.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SmartContactManagerApplication  implements CommandLineRunner	 {
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(SmartContactManagerApplication.class, args);



	}


	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Starting code");
//		User users=new User();
//		users.setFirstName("Abhishek ");
//		users.setLastName("Sharma");
//		users.setUserName("Abhi22");
//		users.setPassword("as");
//		users.setImage("default.JPG");
//		users.setEmail("Abhu@12");
//
//		Role role1 =new Role();
//		role1.setRoleId(45L);
//		role1.setRoleName("NORMAL");
//
//		Set<UserRole> userRolesSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(users);
//
//		userRolesSet.add(userRole);
//
//		User user1=this.userService.cerateUser(users,userRolesSet);
//		System.out.println(user1.getUserName());

	}
}
