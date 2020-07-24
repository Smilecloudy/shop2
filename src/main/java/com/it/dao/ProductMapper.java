package com.it.dao;

import com.github.pagehelper.Page;
import com.it.entity.Category;
import com.it.entity.Product;

import java.util.List;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/12 14:00
 */
public interface ProductMapper {

    //Get the most popular products.
    public List<Product> findHotProduct();

    //Get the most newest products through ajax request.
    public List<Product> findNewProduct();

    //get all product categories
    public List<Category> findAllCategory();

    //get product pagination through cid.
    public List<Product> findProductByCid(Integer cid);

    //get product detail via pid
    public Product findProductByPid(Integer pid);
}
