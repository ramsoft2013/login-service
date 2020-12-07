package com.loginservice.feignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loginservice.constants.MicroServiceConstants;
import com.loginservice.requestDTO.AdminRequestDTO;
import com.loginservice.responseDTO.AdminResponseDTO;

@FeignClient(name = "employee-service")
//@Service
@RequestMapping("/api/v1")
public interface AdminInterface {

    @RequestMapping("/search")
    AdminResponseDTO searchAdmin(@RequestBody AdminRequestDTO requestDTO);

    @RequestMapping("/update")
    void updateAdmin(@RequestBody AdminResponseDTO responseDTO);
    
    @RequestMapping(value="/getusers/{username}",method=RequestMethod.GET)
    AdminResponseDTO fetchAdminByUsername(@PathVariable("username") String username);
	/*
	 * @RequestMapping(value="/testmethod",method=RequestMethod.GET) String
	 * testgetmethood();
	 */
}
