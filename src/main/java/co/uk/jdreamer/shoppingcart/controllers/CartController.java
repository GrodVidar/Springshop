package co.uk.jdreamer.shoppingcart.controllers;

import co.uk.jdreamer.shoppingcart.models.Cart;
import co.uk.jdreamer.shoppingcart.models.Product;
import co.uk.jdreamer.shoppingcart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
@Controller
public class CartController {

    @Autowired
    private ProductRepository productRepository;
    //ADD PRODUCT
    @GetMapping("/add/{id}")
    public String add(@PathVariable long id, Model model, HttpSession session, @RequestParam(value = "cartPage", required = false) String cartPage) {
        Product product = productRepository.findById(id);
        //NEW CART IF EMPTY
        if (session.getAttribute("cart") == null) {
            Map<Long, Cart> cart = new HashMap<Long, Cart>();
            cart.put(id, new Cart(id, product.getName(), product.getPrice(), 1));
            session.setAttribute("cart", cart);
        } else {
            Map<Long, Cart> cart = (Map<Long, Cart>) session.getAttribute("cart");
            if (cart.containsKey(id)) {
                int quantity = cart.get(id).getQuantity();
                cart.put(id, new Cart(id, product.getName(), product.getPrice(), ++quantity));
            } else {
                cart.put(id, new Cart(id, product.getName(), product.getPrice(), 1));
                session.setAttribute("cart", cart);
            }
        }
        //FILLS CART
        Map<Long, Cart> cart = (Map<Long, Cart>) session.getAttribute("cart");

        int size = 0;
        double total = 0;

        for (Cart value : cart.values()) {
            size += value.getQuantity();
            total += value.getQuantity() * Double.parseDouble(value.getPrice());
        }

        model.addAttribute("size", size);
        model.addAttribute("total", total);
        return "redirect:/cart";
    }
    //DELETES BY PRODUCT FROM DATABASE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        productRepository.deleteById(id);
        return "redirect:/cart";
    }
    // CLEAR CART
    @GetMapping("/clear")
    public String clear(HttpSession session, HttpServletRequest httpServletRequest) {
        session.removeAttribute("cart");
        return "redirect:/cart";
    }
    //CHECKOUT
    @GetMapping("/checkout")
    public String checkout(HttpSession session, HttpServletRequest httpServletRequest) {
        session.removeAttribute("cart");
        return "checkout";
    }

    //VIEW CART
    @RequestMapping("/view")
    public String view(HttpSession session, Model model) {

        if (session.getAttribute("cart") == null){
            return "redirect:/cart";
        }
        Map<Long, Cart> cart = (Map<Long, Cart>) session.getAttribute("cart");
        model.addAttribute("cart", cart);
        model.addAttribute("notCartViewPage", true);

        //Calls product ID
        ArrayList<Long>productKeys = new ArrayList<>();
        int totalPrice = 0;
        for (Long key : cart.keySet()) {
            productKeys.add(key);
        }
        System.out.println(productKeys);
        //Calls cart
        for (int i = 0; i < productKeys.size(); i++){
            Cart a = cart.get(productKeys.get(i));
            totalPrice += Integer.parseInt(a.getPrice());
        }
        System.out.println(totalPrice);
        //Links to cart.view
        model.addAttribute("totalprice", totalPrice);

        return "cart_view";
    }

}
