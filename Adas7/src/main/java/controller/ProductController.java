package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import model.Product;
import service.ProductService;

@Controller
public class ProductController {//Tạo controller cho việc hiển thị chi tiết sản phẩm:

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        // Điều hướng đến trang hiển thị danh sách sản phẩm và trả về tên template
        return "products";
    }
}