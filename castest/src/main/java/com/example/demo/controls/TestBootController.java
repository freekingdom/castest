package com.example.demo.controls;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImpl;

@RestController
@EnableAutoConfiguration
public class TestBootController {
	@Resource
	UserServiceImpl userServiceImpl;
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("index");
        return mv;
	}
	
	@RequestMapping("getuser")
    public User getUser() {
        User user = userServiceImpl.getUserById(1);
        return user;
    }
	
	@RequestMapping("logout")
    public void logout(HttpSession session,HttpServletResponse response){
        session.invalidate();
        try {
			response.sendRedirect("http://localhost:8080/cas/logout");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
