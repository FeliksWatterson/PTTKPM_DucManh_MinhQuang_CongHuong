package com.PTTKPM_DucManh_MinhQuang_CongHuong.repository;

import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}