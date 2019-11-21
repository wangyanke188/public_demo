package com.fzy.sys.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * banner图
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-11 10:14:46
 */
public class BannerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增编号
	private Integer id;
	//banner标题
	private String bannerTitle;
	//banner图片放置路径
	private String imageUrl;
	//banner图跳转链接
	private String bannerUrl;
	//排序
	private Integer sort;
	//类型1:导航 2:服务项目
	private Integer type;
	//关联所属类型编号
	private Integer relevanceId;
	//banner状态 0:有效 1:无效
	private Integer state;
	//创建时间
	private Date createTime;
	//是否删除 0:否 1:是
	private Integer isDelete;

	/**
	 * 设置：自增编号
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增编号
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：banner标题
	 */
	public void setBannerTitle(String bannerTitle) {
		this.bannerTitle = bannerTitle;
	}
	/**
	 * 获取：banner标题
	 */
	public String getBannerTitle() {
		return bannerTitle;
	}
	/**
	 * 设置：banner图片放置路径
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：banner图片放置路径
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：banner图跳转链接
	 */
	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}
	/**
	 * 获取：banner图跳转链接
	 */
	public String getBannerUrl() {
		return bannerUrl;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：类型1:导航 2:服务项目
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型1:导航 2:服务项目
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：关联所属类型编号
	 */
	public void setRelevanceId(Integer relevanceId) {
		this.relevanceId = relevanceId;
	}
	/**
	 * 获取：关联所属类型编号
	 */
	public Integer getRelevanceId() {
		return relevanceId;
	}
	/**
	 * 设置：banner状态 0:有效 1:无效
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：banner状态 0:有效 1:无效
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：是否删除 0:否 1:是
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否删除 0:否 1:是
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
}
