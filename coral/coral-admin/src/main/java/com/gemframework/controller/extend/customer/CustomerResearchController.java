/**
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.controller.extend.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.gemframework.annotation.Log;
import com.gemframework.common.utils.GemBeanUtils;
import com.gemframework.constant.GemModules;
import com.gemframework.controller.prekit.BaseController;
import com.gemframework.model.common.BaseResultData;
import com.gemframework.model.common.PageInfo;
import com.gemframework.model.common.validator.SaveValidator;
import com.gemframework.model.common.validator.UpdateValidator;
import com.gemframework.model.enums.ErrorCode;
import com.gemframework.model.enums.OperateType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gemframework.model.entity.po.CustomerResearch;
import com.gemframework.model.entity.vo.CustomerResearchVo;
import com.gemframework.service.CustomerResearchService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: CustomerResearchController
 * @Date: 2020-05-10 17:39:43
 * @Version: v1.0
 * @Description: 客户信息表控制器
 * @Author: yuanrise
 * @Email: 1649951967@qq.com
 * @Copyright: Copyright (c) 2020 wanyong
 * @Company: www.gemframework.com
 */
@Slf4j
@RestController
@RequestMapping(GemModules.Extend.PATH_PRE+"/customer/customerResearch")
public class CustomerResearchController extends BaseController {

    private static final String moduleName = "客户信息表";

    @Autowired
    private CustomerResearchService customerResearchService;

    /**
     * 获取列表分页
     * @return
     */
    @GetMapping("/page")
    @RequiresPermissions("customerResearch:page")
    public BaseResultData page(PageInfo pageInfo, CustomerResearchVo vo) {
        QueryWrapper queryWrapper = makeQueryMaps(vo);
        Page page = customerResearchService.page(setOrderPage(pageInfo),queryWrapper);
        return BaseResultData.SUCCESS(page.getRecords(),page.getTotal());
    }
    /**
     * 获取列表
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("customerResearch:list")
    public BaseResultData list(CustomerResearchVo vo) {
        QueryWrapper queryWrapper = makeQueryMaps(vo);
        List list = customerResearchService.list(queryWrapper);
        return BaseResultData.SUCCESS(list);
    }

    /**
     * 添加
     * @return
     */
    @Log(type = OperateType.ALTER,value = "保存"+moduleName)
    @PostMapping("/save")
    @RequiresPermissions("customerResearch:save")
    public BaseResultData save(@RequestBody CustomerResearchVo vo) {
        GemValidate(vo, SaveValidator.class);
        CustomerResearch entity = GemBeanUtils.copyProperties(vo, CustomerResearch.class);
        if(!customerResearchService.save(entity)){
            return BaseResultData.ERROR(ErrorCode.SAVE_OR_UPDATE_FAIL);
        }
        return BaseResultData.SUCCESS(entity);
    }


    /**
     * 删除 & 批量刪除
     * @return
     */
    @Log(type = OperateType.ALTER,value = "删除"+moduleName)
    @PostMapping("/delete")
    @RequiresPermissions("customerResearch:delete")
    public BaseResultData delete(Long id,String ids) {
        if(id!=null) customerResearchService.removeById(id);
        if(StringUtils.isNotBlank(ids)){
            List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s ->Long.parseLong(s.trim())).collect(Collectors.toList());
            if(listIds!=null && !listIds.isEmpty()){
                    customerResearchService.removeByIds(listIds);
            }
        }
        return BaseResultData.SUCCESS();
    }


    /**
     * 编辑
     * @return
     */
    @Log(type = OperateType.ALTER,value = "编辑"+moduleName)
    @PostMapping("/update")
    @RequiresPermissions("customerResearch:update")
    public BaseResultData update(@RequestBody CustomerResearchVo vo) {
        GemValidate(vo, UpdateValidator.class);
        CustomerResearch entity = GemBeanUtils.copyProperties(vo, CustomerResearch.class);
        if(!customerResearchService.updateById(entity)){
            return BaseResultData.ERROR(ErrorCode.SAVE_OR_UPDATE_FAIL);
        }
        return BaseResultData.SUCCESS(entity);
    }


    /**
     * 获取用户信息ById
     * @return
     */
    @Log(type = OperateType.NORMAL,value = "查看"+moduleName)
    @GetMapping("/info")
    @RequiresPermissions("customerResearch:info")
    public BaseResultData info(Long id) {
        CustomerResearch info = customerResearchService.getById(id);
        return BaseResultData.SUCCESS(info);
    }

}