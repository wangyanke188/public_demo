package com.fzy.sys.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-11 10:14:51
 */
public class NavDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增编号
	private Integer id;
	//导航名称
	private String name;
	//跳转链接
	private String url;
	//创建时间
	private Date createTime;
	//是否删除 0:否 1:是
	private Integer isDelete;
	//排序
	private Integer sort;

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
	 * 设置：导航名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：导航名称
	 */
	public String getName() {
		return name;
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
}
