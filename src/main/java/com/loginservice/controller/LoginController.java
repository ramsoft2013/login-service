package com.loginservice.controller;

import static org.springframework.http.ResponseEntity.ok;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginservice.constants.WebResourceKeyConstants;
import com.loginservice.requestDTO.LoginRequestDTO;
import com.loginservice.service.LoginService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDTO requestDTO, HttpServletRequest request) {

        String token = loginService.login(requestDTO, request);
        System.out.println("login controller :: tokn --->>"+token);
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "test done";
    }
    
	/*
	 * @GetMapping("/testmethod") public ResponseEntity<String> testmethod() {
	 * String value=loginService.testgetmethood();
	 * System.out.println("asdd::"+value); return new ResponseEntity<>(value,
	 * HttpStatus.OK); }
	 */
}
