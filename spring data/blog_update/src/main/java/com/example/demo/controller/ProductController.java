package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.model.Category;
import com.example.demo.service.IProductService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @ModelAttribute("categoryList")
    public List<Category> getList(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public String getList1(Model model, @RequestParam(defaultValue = "0") int page,
                           Optional<String> nameSearch, Optional<String> priceSearch,Optional<String> categoryIdSearch){
        String nameSearchValue ="";
        String priceSearchValue ="";
        String categoryIdSearchValue ="";
        if (nameSearch.isPresent()){
            nameSearchValue =nameSearch.get();
        }
        if (priceSearch.isPresent()){
            priceSearchValue =priceSearch.get();
        }
        if (categoryIdSearch.isPresent()){
            categoryIdSearchValue =categoryIdSearch.get();
        }
        model.addAttribute("nameSearch",nameSearchValue);
        model.addAttribute("priceSearch",priceSearchValue);
        model.addAttribute("categoryIdSearch",categoryIdSearchValue);
        Page<Product> products =productService.findByAll(PageRequest.of(page,3),nameSearchValue,priceSearchValue,categoryIdSearchValue);
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        return "product/create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute @Validated ProductDTO productDTO, BindingResult bindingResult, Model model){
        Product product = new Product();
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "Thêm mới không thành công");
            return "/product/create";
        }else {
            BeanUtils.copyProperties(productDTO,product);
            productService.save(product);
            model.addAttribute("productDTO",productDTO);
            model.addAttribute("mess", "Thêm mới thành công");
        }
        return "redirect:/product";
    }

    @GetMapping("edit")
    public String showEdit(Model model, @RequestParam Integer id) {
        Product product = productService.findById(id).orElse(null);
        model.addAttribute("productDTO", product);
        return "product/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer idDelete, RedirectAttributes redirectAttribute) {
        productService.delete(idDelete);
        redirectAttribute.addFlashAttribute("mess", "Deleted successfully!");
        return "redirect:/product";
    }
}
