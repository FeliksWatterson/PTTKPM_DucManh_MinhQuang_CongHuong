package com.PTTKPM_DucManh_MinhQuang_CongHuong.repository;

import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Customer;
import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerOrderByOrderDateDesc(Customer customer);
}