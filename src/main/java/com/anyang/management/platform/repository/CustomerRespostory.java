package com.anyang.management.platform.repository;

import com.anyang.management.platform.domain.Customer;

import java.util.List;

public interface CustomerRespostory extends BaseRepository<Customer> {

    List<Customer> getCustomersByEmail(String email);

    List<Customer> getCustomersByMobile(String mobile);

    Customer getCustomerByLoginId(String loginId);
}
