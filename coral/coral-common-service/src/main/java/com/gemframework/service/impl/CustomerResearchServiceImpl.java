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
import com.gemframework.mapper.CustomerResearchMapper;
import com.gemframework.model.entity.po.CustomerResearch;
import com.gemframework.service.CustomerResearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Title: CustomerResearchServiceImpl
 * @Date: 2020-05-10 17:39:43
 * @Version: v1.0
 * @Description: 客户信息表服务实现类
 * @Author: yuanrise
 * @Email: 1649951967@qq.com
 * @Copyright: Copyright (c) 2020 wanyong
 * @Company: www.gemframework.com
 */
@Slf4j
@Service
public class CustomerResearchServiceImpl extends ServiceImpl<CustomerResearchMapper, CustomerResearch> implements CustomerResearchService {

}