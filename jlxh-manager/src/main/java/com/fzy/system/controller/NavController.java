package com.fzy.system.controller;

import java.util.Date;
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
import com.fzy.sys.domain.BannerDO;
import com.fzy.sys.domain.NavDO;
import com.fzy.sys.service.ArticleService;
import com.fzy.sys.service.BannerService;
import com.fzy.sys.service.NavService;
import com.fzy.utils.Constant;
import com.fzy.utils.PageUtils;
import com.fzy.utils.Query;
import com.fzy.utils.R;

/**
 * 
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-11 10:54:23
 */
 
@Controller
@RequestMapping("/sys/nav")
public class NavController {
	@Autowired
	private NavService navService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private BannerService bannerService;
	
	@GetMapping()
	@RequiresPermissions("sys:nav:nav")
	String Nav(){
	    return "system/nav/nav";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sys:nav:nav")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<NavDO> navList = navService.list(query);
		int total = navService.count(query);
		PageUtils pageUtils = new PageUtils(navList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sys:nav:add")
	String add(){
	    return "system/nav/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sys:nav:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		NavDO nav = navService.get(id);
		model.addAttribute("nav", nav);
	    return "system/nav/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sys:nav:add")
	public R save( NavDO nav){
		if(navService.save(nav)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sys:nav:edit")
	public R update( NavDO nav){
		navService.update(nav);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sys:nav:remove")
	public R remove( Integer id){
		if(navService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sys:nav:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		navService.batchRemove(ids);
		return R.ok();
	}
	
	@GetMapping("/article")
	@RequiresPermissions("sys:nav:article")
	String Article(){
	    return "system/nav/article";
	}
	@ResponseBody
	@GetMapping("/artList")
	@RequiresPermissions("sys:nav:article")
	public PageUtils artList(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("type", Constant.ContentType.DAO_HANG);
        Query query = new Query(params);
		List<ArticleDO> articleList = articleService.list(query);
		int total = articleService.count(query);
		PageUtils pageUtils = new PageUtils(articleList, total);
		return pageUtils;
	}
	
	@GetMapping("/addArt/{id}")
	@RequiresPermissions("sys:nav:addArt")
	String addArt(@PathVariable("id") Integer id,Model model){
		model.addAttribute("relevanceId",id);
	    return "system/nav/addArt";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/saveArt")
	@RequiresPermissions("sys:nav:addArt")
	public R save( ArticleDO article){
		article.setCreateTime(new Date());
		article.setType(Constant.ContentType.DAO_HANG);
		article.setIsDelete(0);
		if(articleService.save(article)>0){
			return R.ok();
		}
		return R.error();
	}
	
	@GetMapping("/banner")
	@RequiresPermissions("sys:nav:banner")
	String Banner(){
	    return "system/nav/banner";
	}
	
	@ResponseBody
	@GetMapping("/banList")
	@RequiresPermissions("sys:nav:banner")
	public PageUtils banList(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BannerDO> bannerList = bannerService.list(query);
		int total = bannerService.count(query);
		PageUtils pageUtils = new PageUtils(bannerList, total);
		return pageUtils;
	}
	
	@GetMapping("/addBan/{id}")
	@RequiresPermissions("sys:nav:addBan")
	String addBan(@PathVariable("id") Integer id,Model model){
		model.addAttribute("relevanceId", id);
	    return "system/nav/addBan";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/saveBan")
	@RequiresPermissions("sys:nav:addBan")
	public R save( BannerDO banner){
		banner.setCreateTime(new Date());
		banner.setIsDelete(0);
		banner.setType(Constant.ContentType.DAO_HANG);
		if(bannerService.save(banner)>0){
			return R.ok();
		}
		return R.error();
	}
	
}
