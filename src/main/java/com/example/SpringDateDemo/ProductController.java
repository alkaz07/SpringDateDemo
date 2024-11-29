package com.example.SpringDateDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    //@Autowired
   // ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Всем здрасти");
        List<Product> products = productRepository.findAll();
        System.out.println("products = " + products);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/{id}")
    public String showProduct(@PathVariable int id, Model model){
        Optional<Product> oProduct = productRepository.findById(id);

        if(oProduct.isPresent()){
            model.addAttribute("product", oProduct.get());
            return "product";
        }
        else
            return "redirect:/";

    }

    //если сделать форму добавления нового товара,
    //то она приведет на страницу "/add"
    @GetMapping("/add")
    public String addProduct(String name, Double price, String description, Model model){
        Product product = new Product(0, name, price, description);
        productRepository.save(product);

        return "redirect:/";

    }

    @GetMapping("/deleteProd")
    public String deleteProduct( int id, Model model){
        productRepository.deleteById(id);
        return "redirect:/";
    }
}
