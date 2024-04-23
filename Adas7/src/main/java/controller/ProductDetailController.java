package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import model.Product;
import service.ProductService;

@Controller
public class ProductDetailController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        // Điều hướng đến trang hiển thị chi tiết sản phẩm và trả về tên template
        return "product_detail";
    }
}