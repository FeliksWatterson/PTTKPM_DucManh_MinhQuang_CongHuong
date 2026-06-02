package com.PTTKPM_DucManh_MinhQuang_CongHuong.repository;

import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Address;
import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCustomer(Customer customer);
    Optional<Address> findByCustomerAndIsDefaultTrue(Customer customer);
    long countByCustomer(Customer customer);
}