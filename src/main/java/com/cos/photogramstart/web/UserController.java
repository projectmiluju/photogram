package com.cos.photogramstart.web;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String profile(@PathVariable Integer id) {
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String update(@PathVariable Integer id, @AuthenticationPrincipal PrincipalDetails principalDetails){
        return "user/update";
    }
}
