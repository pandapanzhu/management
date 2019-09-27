package com.anyang.management.platform.service.impl;

import com.anyang.management.platform.domain.Entities;
import com.anyang.management.platform.repository.EntitiesRepository;
import com.anyang.management.platform.service.EntitiesService;
import com.anyang.management.platform.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;

public class EntitiesServiceImpl  implements EntitiesService {

    @Resource
    private EntitiesRepository entitiesRepository;

    @Override
    public Entities save(Entities entities) {
        return entitiesRepository.save(entities);
    }

    @Override
    public Page<Entities> getAll(PageUtils page) {
        Pageable pageable =PageRequest.of(page.getPageNo(),page.getPageSize(),new Sort(Sort.Direction.DESC));
        return entitiesRepository.findAll(pageable);
    }
}
