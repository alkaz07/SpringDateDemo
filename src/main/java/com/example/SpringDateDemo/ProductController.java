package com.example.SpringDateDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    //@Autowired
   // ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Всем здрасти");
        return "index";
    }
}
