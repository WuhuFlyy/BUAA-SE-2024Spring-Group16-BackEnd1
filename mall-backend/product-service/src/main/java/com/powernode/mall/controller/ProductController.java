package com.powernode.mall.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.powernode.mall.client.ProductClient;
import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.ProductNoDetails;
import com.powernode.mall.dto.ShopItem;
import com.powernode.mall.service.IProductService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private IProductService productService;

    @RequestMapping("details_test")
    public JsonResult<ProductDetails> detailsTest(int id){

        return productClient.getProductById(id);
    }

    public JsonResult<ProductDetails> fallbackMethod(int id) {
        System.out.println("降级方法");
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(id);
        productDetails.setName("等待");
        return new JsonResult<>(OK,  productDetails);
    }
}
