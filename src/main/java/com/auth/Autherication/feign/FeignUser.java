package com.auth.Autherication.feign;

import com.auth.Autherication.model.UserDto;
import com.auth.Autherication.model.UserWithOutPassword;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="user-service")
public interface FeignUser {
    @PostMapping("/users")
    UserWithOutPassword createUser(UserDto userDto);

    @GetMapping("/users/getUserByEmail/{emailId}")
    UserWithOutPassword getUserDetailsByEmail(@PathVariable("emailId") String emailId);
}
