package com.it.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.dao.ProductMapper;
import com.it.entity.Category;
import com.it.entity.Product;
import com.it.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/12 13:59
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    //Get the most popular products
    public List<Product> findHotProduct() {
        return productMapper.findHotProduct();
    }

    //Get the most newest products through ajax request.
    public List<Product> findNewProduct() {
        return productMapper.findNewProduct();
    }

    //get all product categories
    public String findAllCategory() throws JsonProcessingException {

        //Jedis jedis = JedisUtil.getJedis();
        //String categoryListJson = jedis.get("categoryListJson");
        //if (categoryListJson == null) {
            //If there is no json string in the redis cache, go to the database to find.
            List<Category> categories = productMapper.findAllCategory();
            //Convert categories to string json

        String category = new ObjectMapper().writeValueAsString(categories);
        //Put category list json into redis database.
            //jedis.set("categoryListJson", categoryListJson);

        //}

        //jedis.close();
        return category;
    }

    //get product pagination through cid.
    public Page<Product> findProductByCid(Integer cid,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Product> products = (Page<Product>) productMapper.findProductByCid(cid);
        System.out.println(products);
        return products;
    }

    //Get product details via pid
    public Product findProductByPid(Integer pid) {
        return productMapper.findProductByPid(pid);
    }
}
