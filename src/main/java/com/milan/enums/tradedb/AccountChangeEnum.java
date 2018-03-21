/*
 * Copyright (C) 2016  HangZhou YuShi Technology Co.Ltd  Holdings Ltd. All rights reserved
 *
 * 本代码版权归杭州宇石科技所有，且受到相关的法律保护。
 * 没有经过版权所有者的书面同意，
 * 任何其他个人或组织均不得以任何形式将本文件或本文件的部分代码用于其他商业用途。
 *
 */
package com.milan.enums.tradedb;

/**
 * 【删除枚举】
 *
 * @version 
 * @author wenfei  2017年4月6日 下午6:33:49
 * 
 */
public enum AccountChangeEnum {

	POINTACCTRECHARGE(1, "喵点收入"),
	POINTACCTWITHDRAW(2, "喵点支出"),
	WECHATACCTRECHARGE(3,"微信账户收入"),
	WECHATACCTWITHDRAW(4,"微信账户支出"),
    ;

	private Integer code;
	private String message;

	private AccountChangeEnum(Integer code, String message){
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	public static AccountChangeEnum getEnum(Integer vCodeType) {
		for (AccountChangeEnum accountChangeEnum: AccountChangeEnum.values()) {
			if (accountChangeEnum.getCode().equals(vCodeType)) {
				return accountChangeEnum;
			}
		}
		return null;
	}
	
	
}
