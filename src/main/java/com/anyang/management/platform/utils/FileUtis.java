package com.anyang.management.platform.utils;


import com.alibaba.fastjson.JSONObject;
import com.anyang.management.platform.domain.Entities;
import com.anyang.management.platform.domain.JhipsterEntity;
import com.anyang.management.platform.domain.JhipsterFiled;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public  class FileUtis {

    private static final String staticFilesWin = "";

    private static final String staticFilesLinux = "";

    public static void writeNIO(String fileName, List<Entities> entitiesList) throws IOException, InterruptedException {
        /**
         * 一个entities就是一张表
         * 这里需要建立多个文件
         * 并返回文件夹的名称
         */
        for(Entities entities :entitiesList){
            String name  =".jhipster/"+fileName+entities.getEntityName()+".json";
            //这里不能直接把object传进去，应该进行一些修改之后传个JSON过去
            //这里需要用到映射去解析模板文件了
            List<JhipsterFiled> filedList = new ArrayList<>();
            Field[] fileds = entities.getClass().getDeclaredFields();
            //将Fileds转换成fildList
            for(Field filed : fileds){
                JhipsterFiled filed1 = new JhipsterFiled();
                filed1.setFieldType("");
                filed.getType();
                filed.getName();
                filedList.add(filed1);
            }


            JhipsterEntity jhipsterEntity =new JhipsterEntity(filedList,entities.getEntityName());



            writeFile(name,jhipsterEntity);
            Thread.sleep(100L);
        }
    }


    public static void writeFile(String fileName,Object object) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName,true);
        FileChannel channel = fos.getChannel();
        StringBuffer content = new StringBuffer();
        content.append(object).append("\r\n");
        ByteBuffer buf = ByteBuffer.wrap(content.toString().getBytes());
        buf.put(content.toString().getBytes());
        buf.flip();
        channel.write(buf);
        channel.close();
        fos.close();

    }

    public static boolean runCMD(String cmd) throws IOException, InterruptedException {

        String filePath= staticFilesWin;
        String os = System.getProperty("os.name");
        if(!os.contains("win")){
            filePath= staticFilesLinux;
        }

        final String METHOD_NAME = "runCMD";
        Process p = Runtime.getRuntime().exec(cmd,null,new File(filePath));//这里的file应该是指定到对应的目录
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String readLine = br.readLine();
            StringBuilder builder = new StringBuilder();
            while (readLine != null) {
                readLine = br.readLine();
                builder.append(readLine);
            }
            log.debug(METHOD_NAME + "#readLine: " + builder.toString());

            p.waitFor();
            int i = p.exitValue();
            log.info(METHOD_NAME + "#exitValue = " + i);
            if (i == 0) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            log.error(METHOD_NAME + "#ErrMsg=" + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }


}
