package com.fzy.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fzy.sys.domain.SetupDO;
import com.fzy.sys.service.SetupService;
import com.fzy.utils.PageUtils;
import com.fzy.utils.Query;
import com.fzy.utils.R;

/**
 * 网站配置
 * 
 * @author Wang Yanke
 * @email 15638836857@163.com
 * @date 2019-02-19 16:38:43
 */
 
@Controller
@RequestMapping("/sys/setup")
public class SetupController {
	@Autowired
	private SetupService setupService;
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sys:setup:setup")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SetupDO> setupList = setupService.list(query);
		int total = setupService.count(query);
		PageUtils pageUtils = new PageUtils(setupList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("sys:setup:add")
	String add(){
	    return "system/setup/add";
	}

	@GetMapping("/edit")
	@RequiresPermissions("sys:setup:edit")
	String edit(@RequestParam Map<String, Object> params,Model model){
		SetupDO setup=new SetupDO();
		List<SetupDO> setupList = setupService.list(params);
		if(setupList!=null&&setupList.size()>0){
			setup=setupList.get(0);
		}
		model.addAttribute("setup",setup);
	    return "system/setup/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sys:setup:add")
	public R save( SetupDO setup){
		if(setup.getId()!=null){
			setupService.update(setup);
			return R.ok();
		}else{
			if(setupService.save(setup)>0){
				return R.ok();
			}
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sys:setup:edit")
	public R update( SetupDO setup){
		setupService.update(setup);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sys:setup:remove")
	public R remove( Integer id){
		if(setupService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sys:setup:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		setupService.batchRemove(ids);
		return R.ok();
	}
	
}
