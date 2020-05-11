/**
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gemframework.mapper.DictionaryMapper;
import com.gemframework.model.common.DictionaryMap;
import com.gemframework.model.entity.po.Dictionary;
import com.gemframework.model.enums.DictionaryType;
import com.gemframework.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: DictionaryServiceImpl
 * @Date: 2020-04-16 23:39:03
 * @Version: v1.0
 * @Description: 字典表
 * @Author: gem
 * @Email: gemframe@163.com
 * @Copyright: Copyright (c) 2020 wanyong
 * @Company: www.gemframework.com
 */
@Slf4j
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    @Override
    public Dictionary getByKey(String key) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("key_name",key);
        Dictionary dictionary = getOne(queryWrapper);
        if(dictionary != null){
            return dictionary;
        }
        return null;
    }

    @Override
    public String getCfgByKey(String key) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("key_name",key);
        queryWrapper.eq("type",DictionaryType.CONFIG.getCode());
        Dictionary dictionary = getOne(queryWrapper);
        if(dictionary != null){
            return dictionary.getValueStr();
        }
        return null;
    }


    @Override
    public List<DictionaryMap> getMapsByKey(String key) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("key_name",key);
        queryWrapper.eq("type",DictionaryType.OPTIONS.getCode());
        Dictionary dictionary = getOne(queryWrapper);
        if(dictionary != null){
            List<DictionaryMap> list = JSONArray.parseArray(dictionary.getValueStr(), DictionaryMap.class);
            return list;
        }
        return null;
    }

    @Override
    public String getMapValue(String dictionaryKey,String mapKey) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("key_name",dictionaryKey);
        queryWrapper.eq("type",DictionaryType.OPTIONS.getCode());
        Dictionary dictionary = getOne(queryWrapper);
        if(dictionary != null){
            List<DictionaryMap> list = JSONArray.parseArray(dictionary.getValueStr(), DictionaryMap.class);
            for(DictionaryMap map:list){
                if(map.getMapKey().equals(mapKey)){
                    return map.getMapVal();
                }
            }
        }
        return null;
    }
}