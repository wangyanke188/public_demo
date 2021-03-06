package com.fzy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fzy.domain.UploadDo;

/**
 * 路径映射
 */
@Component
class WebConfigurer implements WebMvcConfigurer {//WebMvcConfigurerAdapter 已过时
	@Autowired
	UploadDo bootdoConfig;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**").addResourceLocations("file:///"+bootdoConfig.getUpload());
		registry.addResourceHandler("/files/**").addResourceLocations("http://"+bootdoConfig.getUploadPath()+"/files/");

	}

}