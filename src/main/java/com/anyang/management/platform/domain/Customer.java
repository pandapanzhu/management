package com.anyang.management.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 客户使用的账号信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity{

    private Long id;

    private String name;

    private String mobile;

    private String email;

    private String loginId;

}
