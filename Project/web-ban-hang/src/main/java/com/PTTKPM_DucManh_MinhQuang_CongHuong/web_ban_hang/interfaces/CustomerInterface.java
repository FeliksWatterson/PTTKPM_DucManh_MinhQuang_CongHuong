package com.PTTKPM_DucManh_MinhQuang_CongHuong.interfaces;

import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Customer;

import java.util.Optional;

public interface CustomerInterface {

    Customer registerCustomer(Customer customer);
    Customer findById(Long id);
    void updateCustomer(Customer customer);
    Optional<Customer> findCustomerByEmail(String email);
    Optional<Customer> authenticateCustomer(String email, String rawPassword);

    boolean updatePassword(Long customerId, String oldPassword, String newPassword);
    void deleteCustomer(Long customerId);
}