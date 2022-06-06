package com.example.ds_khach_hang.model.service;

import com.example.ds_khach_hang.model.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<Customer> findAll();
    public Customer findOne(Long id);
    public Customer save(Customer customer);
    public List<Customer> save(List<Customer> customers);
    public boolean exists(Long id);
    public List<Customer> findAll(List<Long> ids);
    public long count();
    public void delete(Long id);
    public void delete(Customer customer);
    public void delete(List<Customer> customers);
    public void deleteAll();
}
