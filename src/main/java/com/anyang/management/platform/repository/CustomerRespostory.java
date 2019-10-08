package com.anyang.management.platform.repository;

import com.anyang.management.platform.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRespostory extends BaseRepository<Customer> {

    List<Customer> getCustomersByEmail(String email);

    List<Customer> getCustomersByMobile(String mobile);

    Customer getCustomerByLoginId(String loginId);
}
