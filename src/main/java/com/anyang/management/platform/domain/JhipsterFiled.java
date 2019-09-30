package com.anyang.management.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JhipsterFiled {

    private String fieldName;

    private String fieldType;

    private List<String> fieldValidateRules;
}
