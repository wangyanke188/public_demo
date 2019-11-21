package com.fzy.sys.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 系统文章
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-11 10:14:57
 */
public class ArticleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增编号
	private Integer id;
	//标题
	private String articleTitle;
	//作者
	private String author;
	//来源
	private String source;
	//封面图
	private String articleTitleImage;
	//链接
	private String url;
	//简介
	private String introduce;
	//内容
	private String articleContent;
	//1:导航 2:服务类型
	private Integer type;
	//文章类型
	private Integer artType;
	//创建时间
	private Date createTime;
	//变更时间
	private Date updateTime;
	//文章发布时间
	private Date releaseTime;
	//结束时间
	private Date commitTime;
	//是否发布 0:未发布 1:已发布
	private Integer isPublish;
	//是否删除 0:未删除 1:已删除
	private Integer isDelete;
	//是否隐藏文章0:不隐藏 1:隐藏
	private Integer isDisplay;

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
	 * 设置：标题
	 */
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	/**
	 * 获取：标题
	 */
	public String getArticleTitle() {
		return articleTitle;
	}
	/**
	 * 设置：作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：来源
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：封面图
	 */
	public void setArticleTitleImage(String articleTitleImage) {
		this.articleTitleImage = articleTitleImage;
	}
	/**
	 * 获取：封面图
	 */
	public String getArticleTitleImage() {
		return articleTitleImage;
	}
	/**
	 * 设置：链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：链接
	 */
	public String getUrl() {
		return url;
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
	 * 设置：内容
	 */
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	/**
	 * 获取：内容
	 */
	public String getArticleContent() {
		return articleContent;
	}
	/**
	 * 设置：1:导航 2:服务类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1:导航 2:服务类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：文章类型
	 */
	public void setArtType(Integer artType) {
		this.artType = artType;
	}
	/**
	 * 获取：文章类型
	 */
	public Integer getArtType() {
		return artType;
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
	 * 设置：变更时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：变更时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：文章发布时间
	 */
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	/**
	 * 获取：文章发布时间
	 */
	public Date getReleaseTime() {
		return releaseTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getCommitTime() {
		return commitTime;
	}
	/**
	 * 设置：是否发布 0:未发布 1:已发布
	 */
	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}
	/**
	 * 获取：是否发布 0:未发布 1:已发布
	 */
	public Integer getIsPublish() {
		return isPublish;
	}
	/**
	 * 设置：是否删除 0:未删除 1:已删除
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否删除 0:未删除 1:已删除
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：是否隐藏文章0:不隐藏 1:隐藏
	 */
	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}
	/**
	 * 获取：是否隐藏文章0:不隐藏 1:隐藏
	 */
	public Integer getIsDisplay() {
		return isDisplay;
	}
}
