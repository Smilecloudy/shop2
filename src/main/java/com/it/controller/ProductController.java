package com.it.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.Page;
import com.it.entity.Product;
import com.it.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/12 13:59
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    //Get the most popular products through ajax request.
    @RequestMapping(value = "/findHotProduct", produces = "application/json;charset=utf8")
    @ResponseBody
    public List<Product> findHotProduct() {
        List<Product> productList = productService.findHotProduct();
        return productList;
    }

    //Get the most newest products through ajax request.
    @RequestMapping(value = "/findNewProduct", produces = "application/json;charset=utf8")
    @ResponseBody
    public List<Product> findNewProduct() {
        return productService.findNewProduct();
    }

    //Get all product categories
    @RequestMapping(value = "/findAllCategory", produces = "application/json;charset=utf8")
    @ResponseBody
    public String findAllCategory() {
        try {
            return productService.findAllCategory();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/findProductByCid")
    public String findProductByCid(Integer cid,
                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                    Model model) {
        /*
        According to cid, find out all the products in this category, use the paging plug-in to paging,
        put it into the request object, and then forward it to the product list page.
         */
        System.out.println("cid = " + cid);
        Page<Product> products = productService.findProductByCid(cid, pageNum, pageSize);
        model.addAttribute("pageNum",products.getPageNum());
        model.addAttribute("pages", products.getPages());
        model.addAttribute("products", products);
        return "forward:/product_list.jsp";
    }

    @RequestMapping("/findProductByPid")
    public String findProductByPid(Integer pid, Model model) {
        Product product = productService.findProductByPid(pid);
        model.addAttribute("product", product);
        return "forward:/product_info.jsp";
    }
}
