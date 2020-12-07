package com.loginservice.service.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loginservice.feignInterface.AdminInterface;
import com.loginservice.jwt.JwtTokenProvider;
import com.loginservice.requestDTO.LoginRequestDTO;
import com.loginservice.service.LoginService;

@Service
@Transactional("transactionManager")
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AdminInterface adminInterface;

    @Override
    public String login(LoginRequestDTO requestDTO, HttpServletRequest request) {

    	try {
        LOGGER.info("LOGIN PROCESS STARTED ::::");

        adminInterface.fetchAdminByUsername(requestDTO.getUserName());
    	}catch(Exception e) {
    		e.printStackTrace();
    		 LOGGER.error("ERROR ::::",e.getMessage());
    	}

        String jwtToken = jwtTokenProvider.createToken(requestDTO.getUserName(), request);
        System.out.println("LOGIN PROCESS STARTED jwtToken ::::"+jwtToken);
     
        return jwtToken;
    }

      	

}

