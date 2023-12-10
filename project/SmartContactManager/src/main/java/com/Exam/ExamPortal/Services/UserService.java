package com.Exam.ExamPortal.Services;

import com.Exam.ExamPortal.Modelss.UserRole;
import com.Exam.ExamPortal.Modelss.User;

import java.util.Set;

public interface UserService {

    //creating user
    public User cerateUser(User user, Set<UserRole> userRoles) throws Exception;

//get user by username
    public User getUser(String userName);

    //delete user BY Id
    public  void deleteUser(Long userId);

    }

