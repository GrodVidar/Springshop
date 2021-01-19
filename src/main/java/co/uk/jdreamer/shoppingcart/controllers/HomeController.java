package co.uk.jdreamer.shoppingcart.controllers;

import co.uk.jdreamer.shoppingcart.models.Product;
import co.uk.jdreamer.shoppingcart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductRepository rep;
    @GetMapping("/cart")

    //Find all products in MYSQL
    public String homePage(Model model){
        List<Product> products = rep.findAll();
        model.addAttribute("productlist",products);
        return "cart";
    }
}
