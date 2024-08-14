package com.powernode.mall.service;


import com.powernode.mall.dto.ProductDetails;
import com.powernode.mall.dto.ProductNoDetails;
import com.powernode.mall.po.TProduct;

import java.util.List;

public interface IProductService {
    /**
     * 根据商品id获取持久层商品数据
     * @param id 商品id
     * @return 匹配的商品数据，如果没有匹配的数据则返回null
     */
    TProduct selectByPrimaryKey(Integer id);

    /**
     * 根据商品id获取商品概况
     * @param id 商品id
     * @return 匹配的商品概况，无匹配则返回null
     */
    ProductDetails getProductDetailByProductId(Integer id);

    /**
     * 获取当前商城中所有商品
     *
     * @return 一个List储存当前商城中所有商品
     */
    List<ProductNoDetails> getAllProducts();
}
