package com.fzy.common.controller;


import org.springframework.stereotype.Controller;

import com.fzy.domain.UserDO;
import com.fzy.system.utils.ShiroUtils;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}