package com.anyang.management.platform.controller;

import com.anyang.management.platform.domain.Entities;
import com.anyang.management.platform.service.EntitiesService;
import com.anyang.management.platform.utils.PageUtils;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("entities")
public class EntitiesController {

    @Resource
    private EntitiesService entitiesService;

    /**
     * 新增，修改，删除都是调用这个接口，删除的话dlt为1
     * @param entities
     * @return
     */
    @PostMapping("save")
    public Entities saveEntities(@RequestBody  Entities entities){
        entities = entitiesService.save(entities);
        return entities;
    }


    @GetMapping("getAll")
    public Page getEntities(@RequestBody PageUtils page){
        Page pages = entitiesService.getAll(page);
        return pages;
    }


}
