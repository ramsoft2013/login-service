package com.loginservice.service;

import javax.servlet.http.HttpServletRequest;

import com.loginservice.requestDTO.LoginRequestDTO;

public interface LoginService {

     String login(LoginRequestDTO requestDTO, HttpServletRequest request);
   //  String testgetmethood();

}
