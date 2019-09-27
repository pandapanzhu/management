package com.anyang.management.platform.service;

import com.anyang.management.platform.domain.Entities;
import com.anyang.management.platform.utils.PageUtils;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EntitiesService {

    Entities save(Entities entities);

    Page<Entities> getAll(PageUtils page);
}
