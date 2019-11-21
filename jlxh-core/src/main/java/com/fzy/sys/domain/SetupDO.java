package com.fzy.sys.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 网站配置
 * 
 * @author Wang Yanke
 * @email 15638836857@163.com
 * @date 2019-03-11 14:36:50
 */
public class SetupDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//是否开启抽奖
	private Integer prizeIsStart;
	//抽奖开启时间
	private Date prizeStartTime;
	//抽奖结束时间
	private Date prizeEndTime;
	//用户每天可抽奖次数
	private Integer prizeNumberOfDay;
	//积分返点比例
	private Double integralRebate;
	//提现手续费
	private Double cashCharge;
	//客服电话
	private String serviceTelephone;
	//客服微信二维码
	private String serviceImg;
	//商家保证金
	private BigDecimal sellerBaseBalance;
	//关于我们
	private String aboutUsContent;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：是否开启抽奖
	 */
	public void setPrizeIsStart(Integer prizeIsStart) {
		this.prizeIsStart = prizeIsStart;
	}
	/**
	 * 获取：是否开启抽奖
	 */
	public Integer getPrizeIsStart() {
		return prizeIsStart;
	}
	/**
	 * 设置：抽奖开启时间
	 */
	public void setPrizeStartTime(Date prizeStartTime) {
		this.prizeStartTime = prizeStartTime;
	}
	/**
	 * 获取：抽奖开启时间
	 */
	public Date getPrizeStartTime() {
		return prizeStartTime;
	}
	/**
	 * 设置：抽奖结束时间
	 */
	public void setPrizeEndTime(Date prizeEndTime) {
		this.prizeEndTime = prizeEndTime;
	}
	/**
	 * 获取：抽奖结束时间
	 */
	public Date getPrizeEndTime() {
		return prizeEndTime;
	}
	/**
	 * 设置：用户每天可抽奖次数
	 */
	public void setPrizeNumberOfDay(Integer prizeNumberOfDay) {
		this.prizeNumberOfDay = prizeNumberOfDay;
	}
	/**
	 * 获取：用户每天可抽奖次数
	 */
	public Integer getPrizeNumberOfDay() {
		return prizeNumberOfDay;
	}
	/**
	 * 设置：积分返点比例
	 */
	public void setIntegralRebate(Double integralRebate) {
		this.integralRebate = integralRebate;
	}
	/**
	 * 获取：积分返点比例
	 */
	public Double getIntegralRebate() {
		return integralRebate;
	}
	/**
	 * 设置：提现手续费
	 */
	public void setCashCharge(Double cashCharge) {
		this.cashCharge = cashCharge;
	}
	/**
	 * 获取：提现手续费
	 */
	public Double getCashCharge() {
		return cashCharge;
	}
	/**
	 * 设置：客服电话
	 */
	public void setServiceTelephone(String serviceTelephone) {
		this.serviceTelephone = serviceTelephone;
	}
	/**
	 * 获取：客服电话
	 */
	public String getServiceTelephone() {
		return serviceTelephone;
	}
	/**
	 * 设置：客服微信二维码
	 */
	public void setServiceImg(String serviceImg) {
		this.serviceImg = serviceImg;
	}
	/**
	 * 获取：客服微信二维码
	 */
	public String getServiceImg() {
		return serviceImg;
	}
	/**
	 * 设置：商家保证金
	 */
	public void setSellerBaseBalance(BigDecimal sellerBaseBalance) {
		this.sellerBaseBalance = sellerBaseBalance;
	}
	/**
	 * 获取：商家保证金
	 */
	public BigDecimal getSellerBaseBalance() {
		return sellerBaseBalance;
	}
	/**
	 * 设置：关于我们
	 */
	public void setAboutUsContent(String aboutUsContent) {
		this.aboutUsContent = aboutUsContent;
	}
	/**
	 * 获取：关于我们
	 */
	public String getAboutUsContent() {
		return aboutUsContent;
	}
}
