package com.laptrinhjava.service;

import com.laptrinhjava.dto.UserDTO;

public interface IUserService {
   String checkLogin(String username ,String password);
   
   UserDTO createUsers(UserDTO userRequest);
}
