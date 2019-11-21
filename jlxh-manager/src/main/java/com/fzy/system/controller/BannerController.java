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

import com.fzy.sys.domain.BannerDO;
import com.fzy.sys.service.BannerService;
import com.fzy.utils.PageUtils;
import com.fzy.utils.Query;
import com.fzy.utils.R;

/**
 * banner图
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-11 10:54:29
 */
 
@Controller
@RequestMapping("/sys/banner")
public class BannerController {
	@Autowired
	private BannerService bannerService;
	
	@GetMapping()
	@RequiresPermissions("sys:banner:banner")
	String Banner(){
	    return "sys/banner/banner";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sys:banner:banner")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BannerDO> bannerList = bannerService.list(query);
		int total = bannerService.count(query);
		PageUtils pageUtils = new PageUtils(bannerList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sys:banner:add")
	String add(){
	    return "sys/banner/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sys:banner:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		BannerDO banner = bannerService.get(id);
		model.addAttribute("banner", banner);
	    return "sys/banner/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sys:banner:add")
	public R save( BannerDO banner){
		if(bannerService.save(banner)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sys:banner:edit")
	public R update( BannerDO banner){
		bannerService.update(banner);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sys:banner:remove")
	public R remove( Integer id){
		if(bannerService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sys:banner:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		bannerService.batchRemove(ids);
		return R.ok();
	}
	
}
