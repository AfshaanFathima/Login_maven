package com.devops01.demo01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops01.demo01.domain.Login;
import com.devops01.demo01.repository.LoginRepo;

@Service
public class LoginService{
    @Autowired
    private LoginRepo repo;

    public Boolean logdata(String username, String password)
    {
        Login result=repo.findByUsernameAndPassword(username,password);
        if(result!= null)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean signdata(String username, String password)
    {
        Login newUser=new Login(username,password);
        Login result=repo.save(newUser);
        if(result!= null)
        {
            return true;
        }
        else{
            return false;
        }
    }
}