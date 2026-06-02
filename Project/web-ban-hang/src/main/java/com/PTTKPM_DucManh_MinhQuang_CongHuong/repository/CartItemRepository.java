package com.PTTKPM_DucManh_MinhQuang_CongHuong.repository;

import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.CartItem;
import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Customer;
import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying; 
import org.springframework.data.jpa.repository.Query; 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCustomer(Customer customer);

    Optional<CartItem> findByCustomerAndProduct(Customer customer, Product product);

    @Modifying 
    @Transactional 
    @Query("DELETE FROM CartItem ci WHERE ci.customer = ?1 AND ci.product = ?2")
    void deleteByCustomerAndProduct(Customer customer, Product product);

    @Modifying
    @Transactional
    void deleteByCustomer(Customer customer);

    @Query("SELECT SUM(ci.quantity) FROM CartItem ci WHERE ci.customer = ?1")
    Integer sumQuantityByCustomer(Customer customer);
}