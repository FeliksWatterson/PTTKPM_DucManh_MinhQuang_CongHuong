package com.PTTKPM_DucManh_MinhQuang_CongHuong.controller;

import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Product;
import com.PTTKPM_DucManh_MinhQuang_CongHuong.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public String showProductDetail(@PathVariable("id") Long productId, Model model, RedirectAttributes redirectAttributes) {
        Optional<Product> productOpt = productService.findProductById(productId);

        if (productOpt.isPresent()) {
            model.addAttribute("product", productOpt.get());
            return "productdetail"; 
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy sản phẩm với ID: " + productId);
            return "redirect:/";
        }
    }
}