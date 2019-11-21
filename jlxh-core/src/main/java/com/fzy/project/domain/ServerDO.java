package com.fzy.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 服务项目
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-12 10:07:53
 */
public class ServerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增编号
	private Integer id;
	//名称
	private String serveName;
	//内容介绍
	private String serverContent;
	//名称1
	private String serveName1;
	//跳转链接
	private String url;
	//排序
	private Integer sort;
	//内容介绍1
	private String serverContent1;
	//封面图
	private String serverTitleImage;
	//简介
	private String introduce;
	//类型 1:文章 2:视频
	private Integer type;
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
	 * 设置：名称
	 */
	public void setServeName(String serveName) {
		this.serveName = serveName;
	}
	/**
	 * 获取：名称
	 */
	public String getServeName() {
		return serveName;
	}
	/**
	 * 设置：内容介绍
	 */
	public void setServerContent(String serverContent) {
		this.serverContent = serverContent;
	}
	/**
	 * 获取：内容介绍
	 */
	public String getServerContent() {
		return serverContent;
	}
	/**
	 * 设置：名称1
	 */
	public void setServeName1(String serveName1) {
		this.serveName1 = serveName1;
	}
	/**
	 * 获取：名称1
	 */
	public String getServeName1() {
		return serveName1;
	}
	/**
	 * 设置：跳转链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：跳转链接
	 */
	public String getUrl() {
		return url;
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
	 * 设置：内容介绍1
	 */
	public void setServerContent1(String serverContent1) {
		this.serverContent1 = serverContent1;
	}
	/**
	 * 获取：内容介绍1
	 */
	public String getServerContent1() {
		return serverContent1;
	}
	/**
	 * 设置：封面图
	 */
	public void setServerTitleImage(String serverTitleImage) {
		this.serverTitleImage = serverTitleImage;
	}
	/**
	 * 获取：封面图
	 */
	public String getServerTitleImage() {
		return serverTitleImage;
	}
	/**
	 * 设置：简介
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：简介
	 */
	public String getIntroduce() {
		return introduce;
	}
	/**
	 * 设置：类型 1:文章 2:视频
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型 1:文章 2:视频
	 */
	public Integer getType() {
		return type;
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
