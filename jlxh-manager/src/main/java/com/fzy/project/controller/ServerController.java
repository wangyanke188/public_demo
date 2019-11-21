package com.fzy.project.controller;

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

import com.fzy.project.domain.ServerDO;
import com.fzy.project.service.ServerService;
import com.fzy.sys.domain.BannerDO;
import com.fzy.sys.service.BannerService;
import com.fzy.utils.Constant;
import com.fzy.utils.PageUtils;
import com.fzy.utils.Query;
import com.fzy.utils.R;

/**
 * 服务项目
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-12 10:07:53
 */
 
@Controller
@RequestMapping("/project/server")
public class ServerController {
	@Autowired
	private ServerService serverService;
	@Autowired
	private BannerService bannerService;
	
	
	@GetMapping()
	@RequiresPermissions("project:server:server")
	String Server(){
	    return "project/server/server";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("project:server:server")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ServerDO> serverList = serverService.list(query);
		int total = serverService.count(query);
		PageUtils pageUtils = new PageUtils(serverList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("project:server:add")
	String add(){
	    return "project/server/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("project:server:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ServerDO server = serverService.get(id);
		model.addAttribute("server", server);
	    return "project/server/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("project:server:add")
	public R save( ServerDO server){
		if(serverService.save(server)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("project:server:edit")
	public R update( ServerDO server){
		serverService.update(server);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("project:server:remove")
	public R remove( Integer id){
		if(serverService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("project:server:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		serverService.batchRemove(ids);
		return R.ok();
	}
	
	@GetMapping("/banner")
	@RequiresPermissions("project:server:banner")
	String Banner(){
	    return "system/nav/banner";
	}
	
	@ResponseBody
	@GetMapping("/banList")
	@RequiresPermissions("project:server:banner")
	public PageUtils banList(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BannerDO> bannerList = bannerService.list(query);
		int total = bannerService.count(query);
		PageUtils pageUtils = new PageUtils(bannerList, total);
		return pageUtils;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/saveBan")
	@RequiresPermissions("project:server:addBan")
	public R save( BannerDO banner){
		banner.setCreateTime(new Date());
		banner.setIsDelete(0);
		banner.setType(Constant.ContentType.FU_WU_PIN_PAI);
		if(bannerService.save(banner)>0){
			return R.ok();
		}
		return R.error();
	}
	
}
