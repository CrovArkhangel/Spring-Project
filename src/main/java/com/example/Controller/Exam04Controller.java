package com.example.Controller;

import com.example.Domain.User;
import com.example.Form.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
    @GetMapping("")
    public String index(UserForm form){
        return "exam04";
    }

    @PostMapping("/post")
    public String post(
            @Validated UserForm form,
            BindingResult result,
            Model model
    ){
        if (result.hasErrors()){
            return index(form);
        }
        User user = new User();
        BeanUtils.copyProperties(form, user);
        model.addAttribute("user",user);
        return "exam04-result";
    }
}
