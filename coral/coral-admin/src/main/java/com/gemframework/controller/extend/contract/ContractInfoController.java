/**
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.controller.extend.contract;

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
import com.gemframework.utils.DefaultInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gemframework.model.entity.po.ContractInfo;
import com.gemframework.model.entity.vo.ContractInfoVo;
import com.gemframework.service.ContractInfoService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: ContractInfoController
 * @Date: 2020-05-10 18:23:44
 * @Version: v1.0
 * @Description: 合同信息表控制器
 * @Author: yuanrise
 * @Email: 1649951967@qq.com
 * @Copyright: Copyright (c) 2020 wanyong
 * @Company: www.gemframework.com
 */
@Slf4j
@RestController
@RequestMapping(GemModules.Extend.PATH_PRE+"/contract/contractInfo")
public class ContractInfoController extends BaseController {

    private static final String moduleName = "合同信息表";

    @Autowired
    private ContractInfoService contractInfoService;

    /**
     * 获取列表分页
     * @return
     */
    @GetMapping("/page")
    @RequiresPermissions("contractInfo:page")
    public BaseResultData page(PageInfo pageInfo, ContractInfoVo vo) {
        QueryWrapper queryWrapper = makeQueryMaps(vo);
        Page page = contractInfoService.page(setOrderPage(pageInfo),queryWrapper);
        return BaseResultData.SUCCESS(page.getRecords(),page.getTotal());
    }
    /**
     * 获取列表
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("contractInfo:list")
    public BaseResultData list(ContractInfoVo vo) {
        QueryWrapper queryWrapper = makeQueryMaps(vo);
        List list = contractInfoService.list(queryWrapper);
        return BaseResultData.SUCCESS(list);
    }

    /**
     * 添加
     * @return
     */
    @Log(type = OperateType.ALTER,value = "保存"+moduleName)
    @PostMapping("/save")
    @RequiresPermissions("contractInfo:save")
    public BaseResultData save(@RequestBody ContractInfoVo vo) {
        GemValidate(vo, SaveValidator.class);
        ContractInfo entity = GemBeanUtils.copyProperties(vo, ContractInfo.class);
        if(!contractInfoService.save(entity)){
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
    @RequiresPermissions("contractInfo:delete")
    public BaseResultData delete(Long id,String ids) {
        if(id!=null) contractInfoService.removeById(id);
        if(StringUtils.isNotBlank(ids)){
            List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s ->Long.parseLong(s.trim())).collect(Collectors.toList());
            if(listIds!=null && !listIds.isEmpty()){
                    contractInfoService.removeByIds(listIds);
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
    @RequiresPermissions("contractInfo:update")
    public BaseResultData update(@RequestBody ContractInfoVo vo) {
        GemValidate(vo, UpdateValidator.class);
        ContractInfo entity = GemBeanUtils.copyProperties(vo, ContractInfo.class);
        if(!contractInfoService.updateById(entity)){
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
    @RequiresPermissions("contractInfo:info")
    public BaseResultData info(Long id) {
        ContractInfo info = contractInfoService.getById(id);
        return BaseResultData.SUCCESS(info);
    }

}