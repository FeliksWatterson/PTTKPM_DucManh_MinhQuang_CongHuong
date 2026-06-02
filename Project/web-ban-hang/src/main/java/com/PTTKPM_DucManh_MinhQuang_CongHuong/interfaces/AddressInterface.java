package com.PTTKPM_DucManh_MinhQuang_CongHuong.interfaces;

import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Address;
import com.PTTKPM_DucManh_MinhQuang_CongHuong.model.Customer;

import java.util.List;
import java.util.Optional;

public interface AddressInterface {
    List<Address> findAddressesByCustomer(Customer customer);
    Optional<Address> findDefaultAddressByCustomer(Customer customer);
    Address saveAddress(Address address);
    Optional<Address> findByIdAndCustomer(Long id, Customer customer);
    void deleteAddress(Long id, Customer customer);
    void setDefaultAddress(Long id, Customer customer);
    long countAddressesByCustomer(Customer customer);
}