package com.anyang.management.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * 客人创建实体的时候，会先写数据库和项目的名称
 * 然后就是每张表里面的信息
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="tableName")
@EntityListeners(AuditingEntityListener.class)
public class TableName extends BaseEntity{

    private String tableName;

    @OneToMany(mappedBy = "TableNameId")
    private List<Entities> entities;
}
