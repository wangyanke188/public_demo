package com.fzy.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fzy.common.annotation.Log;
import com.fzy.common.controller.BaseController;
import com.fzy.domain.FileDO;
import com.fzy.domain.MenuDO;
import com.fzy.domain.Tree;
import com.fzy.domain.UserDO;
import com.fzy.system.service.FileService;
import com.fzy.system.service.MenuService;
import com.fzy.system.utils.MD5Utils;
import com.fzy.system.utils.ShiroUtils;
import com.fzy.utils.R;
import com.google.code.kaptcha.Constants;

/**
 * @author 马凌冰
 * @date 2019-01-25
 */
@Controller
public class LoginController extends BaseController{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MenuService menuService;
	@Autowired
	FileService fileService;
	@GetMapping({ "/", "" })
	String welcome(Model model) {

		return "redirect:/login";//redirect  重定向
	}

	@Log("请求访问主页")
	@GetMapping({ "/index" })
	String index(Model model) {
		//菜单树
		List<Tree <MenuDO>> menus = menuService.listMenuTree(getUserId());
		UserDO userDO=getUser();
		model.addAttribute("menus", menus);
		model.addAttribute("name", userDO.getName());
		FileDO fileDO = fileService.get(userDO.getPicId());
		if(fileDO!=null&&fileDO.getUrl()!=null){
			if(fileService.isExist(fileDO.getUrl())){
				model.addAttribute("picUrl",fileDO.getUrl());
			}else {
				model.addAttribute("picUrl","/img/photo_s.jpg");
			}
		}else {
			model.addAttribute("picUrl","/img/photo_s.jpg");
		}
		model.addAttribute("username", userDO.getUsername());
		return "index_v1";
	}

	/**
	 *  登录页面
	 * @return
	 */
	@GetMapping("/login")
	String login() {
		return "login";
	}

	/**
	 * 接口登陆
	 * @param username 用户名
	 * @param password 用户密码
	 * @param verify 验证码
	 * @param request
	 * @return
	 */
	@Log("登录")
	@PostMapping("/login")
	@ResponseBody
	R ajaxLogin(String username, String password, String verify, HttpServletRequest request) {
		//String inputVerify=verify;
		password = MD5Utils.encrypt(username, password);
		String katha=ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);//(String)request.getSession().getAttribute("vifityCode");
        if(!katha.equals(verify)){
        	return R.error("验证码不正确");
		}
		try {
			//1、获取subject
			Subject subject = SecurityUtils.getSubject();
			//2、封装用户数据
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			//3、执行登录方法
			subject.login(token);
			return R.ok();//登录成功
		}catch (UnknownAccountException e){//用户名不存在
			return R.error(e.getMessage());
		} catch (IncorrectCredentialsException e) {//密码错误
			return R.error("用户或密码错误");
		}catch (LockedAccountException e){
			return R.error("账号已被锁定,请联系管理员");
		}catch (AuthenticationException e){
			return R.error("用户验证失败");
		}
	}

	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
	String main() {
		return "main";
	}

}
