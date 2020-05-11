/**
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gemframework.mapper.ContractInfoMapper;
import com.gemframework.model.entity.po.ContractInfo;
import com.gemframework.service.ContractInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Title: ContractInfoServiceImpl
 * @Date: 2020-05-10 18:23:44
 * @Version: v1.0
 * @Description: 合同信息表服务实现类
 * @Author: yuanrise
 * @Email: 1649951967@qq.com
 * @Copyright: Copyright (c) 2020 wanyong
 * @Company: www.gemframework.com
 */
@Slf4j
@Service
public class ContractInfoServiceImpl extends ServiceImpl<ContractInfoMapper, ContractInfo> implements ContractInfoService {

}