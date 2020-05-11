/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.model.entity.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gemframework.model.common.BaseEntityPo;
import lombok.Data;

/**
 * @Title: CustomerResearch
 * @Date: 2020-05-10 17:39:43
 * @Version: v1.0
 * @Description: 客户信息表实体
 * @Author: yuanrise
 * @Email: 1649951967@qq.com
 * @Copyright: Copyright (c) 2020 wanyong
 * @Company: www.gemframework.com
 */

@TableName("rise_customer_research")
@Data
public class CustomerResearch extends BaseEntityPo {

										/**
		 * 
		 */
		private String corporateName;
							/**
		 * 
		 */
		private String corporateId;
							/**
		 * 
		 */
		private String corporationName;
							/**
		 * 
		 */
		private String phone;
							/**
		 * 
		 */
		private String phone2;
							/**
		 * 
		 */
		private String address;
							/**
		 * 
		 */
		private String script;
							/**
		 * 
		 */
		private String copy;
							/**
		 * 
		 */
		private String taxInfo;
							/**
		 * 
		 */
		private String enclosure;
							/**
		 * 
		 */
		private String isBill;
							/**
		 * 
		 */
		private String levyFees;
							/**
		 * 
		 */
		private String other1;
							/**
		 * 
		 */
		private String other2;
																												
}

