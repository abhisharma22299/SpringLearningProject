package com.Exam.ExamPortal.Services.Impl;

import com.Exam.ExamPortal.Modelss.UserRole;
import com.Exam.ExamPortal.Services.UserService;
import com.Exam.ExamPortal.Modelss.User;
import com.Exam.ExamPortal.Repo.RoleRepository;
import com.Exam.ExamPortal.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User cerateUser(User user, Set<UserRole> userRoles) throws Exception {

        User local=this.userRepository.findByUserName(user.getUserName());
        if(local!=null){
            System.out.println("User Already Exist");
            throw new Exception("User Already Exist");

        }else {
            // user create
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
        local=   this.userRepository.save(user);
        }
        return local;
    }
// getting user bu username

    @Override
    public User getUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
