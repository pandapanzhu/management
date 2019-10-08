package com.anyang.management.platform.domain;

import org.hibernate.annotations.OnDelete;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 所有实体的基类
 * 包含了一些公共字段在里面
 * 这些字段应该按照需求是否展示
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    public Long id;

    public String remark;

    public Integer dlt;

    @CreatedBy
    public String createUser;

    @CreatedDate
    public String createDate;

    @LastModifiedBy
    public String modifyUser;

    @LastModifiedDate
    public String modifyDate;


}
