package com.example.Controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
    @Autowired
    private ServletContext application;

    @GetMapping("")
    public String index(){
        return "exam03";
    }
    @PostMapping("/post")
    public String post(Integer product1, Integer product2,Integer product3){
        int sum = product1 + product2 + product3;
        application.setAttribute("priceIncludeTax", sum);
        application.setAttribute("priceExcludeTax", sum*1.1);
        return "exam03-result";
    }
}
