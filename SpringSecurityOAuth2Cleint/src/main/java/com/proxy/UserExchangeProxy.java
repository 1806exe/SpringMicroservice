package com.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.User;



@RibbonClient(value="my-users-service")
@FeignClient(value="my-users-service")
public interface UserExchangeProxy {
	
	//@GetMapping(value = "/users/user")
	@RequestMapping(value = "/users/user", method = RequestMethod.GET)
	public List<User> listUser();
	
}
