package com.mahi.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.app.entities.ZerodhaPlatformConfiguration;

@RestController
public class ZerodhaPlatformController {
	
	@Autowired
	private ZerodhaPlatformConfiguration configurator;
	
	@RequestMapping("/zerodha-platform-details")
	public ZerodhaPlatformConfiguration getZerodhaPlatformConfiguration() {
		return configurator;
	}
}
