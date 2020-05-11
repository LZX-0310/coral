/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.model.entity.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gemframework.model.common.BaseEntityVo;
import lombok.Data;

/**
 * @Title: ContractInfoVo
 * @Date: 2020-05-10 18:23:44
 * @Version: v1.0
 * @Description: 合同信息表VO对象
 * @Author: yuanrise
 * @Email: 1649951967@qq.com
 * @Copyright: Copyright (c) 2020 wanyong
 * @Company: www.gemframework.com
 */
@Data
public class ContractInfoVo extends BaseEntityVo {

											/**
			 * 
			 */
			private Long contractId;
								/**
			 * 
			 */
			private String status;
								/**
			 * 
			 */
			@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
			private Date serviceTime;
								/**
			 * 
			 */
			@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
			private Date serviceStartTime;
								/**
			 * 
			 */
			@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
			private Date serviceEndTime;
								/**
			 * 
			 */
			private BigDecimal amountMoney;
								/**
			 * 
			 */
			private BigDecimal amountReceived;
								/**
			 * 
			 */
			private Date signTime;
								/**
			 * 
			 */
			private String signedBy;
								/**
			 * 
			 */
			private String chargingStandard;
								/**
			 * 
			 */
			private String contractNature;
								/**
			 * 
			 */
			private String isBill;
								/**
			 * 
			 */
			private String accounting;
								/**
			 * 
			 */
			private String other1;
								/**
			 * 
			 */
			private String other2;
																												
}
