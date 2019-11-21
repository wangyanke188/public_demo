package com.fzy.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fzy.sys.domain.ArticleDO;
import com.fzy.sys.service.ArticleService;
import com.fzy.utils.PageUtils;
import com.fzy.utils.Query;
import com.fzy.utils.R;


/**
 * 系统文章
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-11 10:54:17
 */
 
@Controller
@RequestMapping("/sys/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@GetMapping()
	@RequiresPermissions("sys:article:article")
	String Article(){
	    return "sys/article/article";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sys:article:article")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ArticleDO> articleList = articleService.list(query);
		int total = articleService.count(query);
		PageUtils pageUtils = new PageUtils(articleList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sys:article:add")
	String add(){
	    return "sys/article/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sys:article:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ArticleDO article = articleService.get(id);
		model.addAttribute("article", article);
	    return "sys/article/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sys:article:add")
	public R save( ArticleDO article){
		if(articleService.save(article)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sys:article:edit")
	public R update( ArticleDO article){
		articleService.update(article);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sys:article:remove")
	public R remove( Integer id){
		if(articleService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sys:article:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		articleService.batchRemove(ids);
		return R.ok();
	}
	
}
