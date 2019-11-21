package com.fzy.system.shiro;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.fzy.common.config.ApplicationContextRegister;
import com.fzy.domain.UserDO;
import com.fzy.system.dao.UserDao;
import com.fzy.system.service.MenuService;
import com.fzy.system.utils.ShiroUtils;

/**
 * 自定义Realm
 * @author 马凌冰
 * @date 2019-01-25
 */
public class UserRealm extends AuthorizingRealm {
/*	@Autowired
	UserDao userMapper;
	@Autowired
	MenuService menuService;*/

	/**
	 * 获取用户的权限
	 * @param arg0
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		//获取用户id
		Long userId = ShiroUtils.getUserId();
		//创建菜单的实例
		MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
		//调取菜单的方法  根据用户id获取关联的菜单
		Set<String> perms = menuService.listPerms(userId);
		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//添加 用户权限
		info.setStringPermissions(perms);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		//UsernamePasswordToken userToken=(UsernamePasswordToken)token;
		//获取页面传过来的username
		String username =(String) token.getPrincipal(); //userToken.getUsername();//

		Map<String, Object> map = new HashMap<>(16);
		map.put("username", username);
		//获取加密后的密码
		String password =new String((char[]) token.getCredentials());// new String((char[])userToken.getPassword());//

		//拿到userMapper
		//public interface UserDao

		UserDao userMapper = ApplicationContextRegister.getBean(UserDao.class);
		// 查询用户信息
		UserDO user = userMapper.list(map).get(0);

		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}

		// 密码错误
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
