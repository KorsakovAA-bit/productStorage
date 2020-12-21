package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dao.ProductDao;
import project.model.Product;

import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao){
        this.productDao = productDao;
    }

    @GetMapping()
    public String getStartedPAge(@ModelAttribute("product") Product product, Model model){
        List<Product> listWithProducts;

        if(product.getName() != null){
            listWithProducts = productDao.getSpecificProduct(product.getName());
        }else {
            listWithProducts = productDao.getAllProducts();
        }
        Collections.sort(listWithProducts);
        model.addAttribute("products", listWithProducts);
        return "startedPage";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("product", new Product());
        return "createNewProduct";
    }

    @PostMapping()
    public String createProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "createNewProduct";
        productDao.addNewProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productDao.getProductById(id));
        return "productPage";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productDao.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String showUpdatePage(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productDao.getProductById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, @PathVariable("id") int id){

        if(bindingResult.hasErrors()) return "edit";
        productDao.updateProduct(id, product);
        return "redirect:/products";
    }
}
