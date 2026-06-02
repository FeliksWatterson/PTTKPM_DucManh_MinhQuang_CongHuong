package com.PTTKPM_DucManh_MinhQuang_CongHuong.interfaces;

import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductInterface {
    Optional<Product> findProductById(Long id);
    List<Product> findAllProducts();
    List<Product> findNewProducts(int limit); 
    List<Product> findBestSellingProducts(int limit); 
    List<Product> findHighlyRatedProducts(int limit); 
    List<Product> findProductsOnSale(int limit); 
}