package com.anyang.management.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 这里是jhipster类文件生成需要字段
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JhipsterEntity {

    private Boolean fluentMethods;

    private List<JhipsterFiled> fields;

    private String service;

    private String entityTableName;

    private String pagination;

    private Boolean jpaMetamodelFiltering;

    private Boolean searchEngine;

    private Integer iconnectColumnsPerRow;

    private Boolean iconnectEnableAudit;

    private Boolean enableEntityAudit;


    public JhipsterEntity(List<JhipsterFiled> fields,String entityTableName){
        this.fields =fields;
        this.fluentMethods = true;
        this.service = "serviceClass";
        this.entityTableName = entityTableName;
        this.pagination = "pagination";
        this.jpaMetamodelFiltering = true;
        this.searchEngine = true;
        this.iconnectColumnsPerRow =2;
        this.iconnectEnableAudit =true;
        this.enableEntityAudit =true;

    }

}
