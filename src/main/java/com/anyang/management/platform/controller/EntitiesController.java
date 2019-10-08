package com.anyang.management.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.anyang.management.platform.domain.Entities;
import com.anyang.management.platform.service.EntitiesService;
import com.anyang.management.platform.utils.FileUtis;
import com.anyang.management.platform.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("entities")
public class EntitiesController {

    @Resource
    private EntitiesService entitiesService;

    /**
     * 新增，修改，删除都是调用这个接口，删除的话dlt为1
     * 保存的时候，这里应该只是保存到数据库，方便下次读取
     * @param entities
     * @return
     */
    @PostMapping("save")
    public Entities saveEntities(@RequestBody  Entities entities){
        entities = entitiesService.save(entities);
        return entities;
    }


    @GetMapping("getAll")
    public Page getEntities(@RequestBody(required = false) PageUtils page){
        Page pages = entitiesService.getAll(page);
        return pages;
    }


    /**
     * 在这里进行项目生成的操作
     * 项目生成的时候，应该是多张表组合成一个完整的系统
     */
    @PostMapping("createProject")
    public String createProject(List<Entities> entities){
        JSONObject jsonObject =new JSONObject();
        try{
            //先把传过来的数据些到脚本里面去
            String filesName = Instant.now().toString();
            FileUtis.writeNIO(filesName,entities); //传进去的是文件夹的名字，所有xml文件都是在这个文件夹下面生成的
            //然后再调用脚本生成
            FileUtis.runCMD(" yo jhipster");//调用jhipster命令，生成对应的项目
        }catch (IOException e){
            jsonObject.put("msg","生成文件时出现了异常");
            return jsonObject.toJSONString();
        }catch (InterruptedException e){
            jsonObject.put("msg","生成文件时线程出现了异常");
            return jsonObject.toJSONString();
        }

        jsonObject.put("msg","success");
        return jsonObject.toJSONString();
    }



}
