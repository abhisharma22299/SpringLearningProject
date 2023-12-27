package com.Exam.ExamPortal.HomeController;


import com.Exam.ExamPortal.Modelss.Role;
import com.Exam.ExamPortal.Modelss.User;
import com.Exam.ExamPortal.Modelss.UserRole;
import com.Exam.ExamPortal.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*") // this is use
public class UserController {
    @Autowired
    private UserService userService;

    //create User
@PostMapping("/")
	public User cerateUser(@RequestBody User user) throws Exception {
    Set<UserRole> roles=new HashSet<>();
   Role role=new Role();
   role.setRoleId(45L);
   role.setRoleName("NORMAL");
   UserRole userRole=new UserRole();
userRole.setUser(user);
 userRole.setRole(role);
    roles.add(userRole);
return this.userService.cerateUser(user,roles);
    }
@GetMapping("/{userName}")
    public User getUser(@PathVariable("userName")String userName)

    {
return this.userService.getUser(userName);
    }
    // delete by user by id

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId")Long userId){

    this.userService.deleteUser(userId);
    }
}
