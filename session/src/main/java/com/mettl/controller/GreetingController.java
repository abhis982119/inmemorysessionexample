package com.mettl.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;

@RestController
@RequestMapping("/user")
public class GreetingController {


    @GetMapping("/save")
    public String saveName(@RequestParam String firstName, @RequestParam String lastName) {
        String userName =  firstName + " " + lastName;
        HttpSession session = getCurrentSession();
        session.setAttribute("userName", userName);
        return "user details saved!";
    }


    @GetMapping
    public String getUser() {
        HttpSession session = getCurrentSession();
        String userName = (String) session.getAttribute("userName");

        Enumeration<String> attributes =  session.getAttributeNames();
        while(attributes.hasMoreElements()){
            String attributeName = attributes.nextElement();
             Object value = session.getAttribute("attributeName");
        }

        return "Hi, Mr. " + userName;
    }

    private HttpSession getCurrentSession() {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest().getSession(true);
    }
}
