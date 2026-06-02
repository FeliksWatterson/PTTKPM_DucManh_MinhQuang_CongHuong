package com.PTTKPM_DucManh_MinhQuang_CongHuong.repository;

import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
