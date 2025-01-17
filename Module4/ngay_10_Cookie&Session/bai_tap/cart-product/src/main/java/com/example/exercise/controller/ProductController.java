package com.example.exercise.controller;

import com.example.exercise.model.Cart;
import com.example.exercise.model.Product;
import com.example.exercise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping("/cart")
    public ModelAndView getCartList(@ModelAttribute("cart") Cart cart) {
        return new ModelAndView("product/listCart", "cartList", cart.getCart());
    }

    @GetMapping("/product")
    public ModelAndView getProductList(){
        return new ModelAndView("product/listProduct", "productList", productService.findAll());
    }

    @GetMapping("/product/create")
    public ModelAndView getCreateForm() {
        return new ModelAndView("product/createProduct", "products", new Product());
    }

    @PostMapping("/product/save")
    public String createNewProduct(Product product) {
        this.productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product/view")
    public ModelAndView getViewForm(Integer id) {
        return new ModelAndView("product/viewProduct", "products", this.productService.findById(id));
    }

    @PostMapping("/cart/add")
    public ModelAndView addToCart(Integer id, @ModelAttribute("cart") Cart cart) {
        Product product = this.productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("product/viewProduct");
        modelAndView.addObject("products", product);
        cart.addToCart(product);
        return modelAndView;
    }

    @GetMapping("/cart/delete")
    public ModelAndView deleteProductInCart(Integer id,  @ModelAttribute("cart") Cart cart) {
        cart.removeProduct(this.productService.findById(id));
        return new ModelAndView("redirect:/cart");
    }

    @GetMapping("/cart/clear")
    public ModelAndView clearAllItem(@ModelAttribute("cart") Cart cart) {
        cart.clearAllProduct();
        return new ModelAndView("redirect:/cart");
    }

}
