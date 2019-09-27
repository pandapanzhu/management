package com.anyang.management.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="entity")
@EntityListeners(AuditingEntityListener.class)
public class Entities extends BaseEntity{
    /**
     * 表主键
     */
    private String id;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 这里面放的是客人录入的实体，键名和字段类型
     * 这里应该是个List,客人会录入多条字段信息
     */
    private List<Map<String,String>> entitys;



}
