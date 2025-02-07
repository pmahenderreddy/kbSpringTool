package com.mahi.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.app.entities.ZerodhaPlatformConfiguration;

@RestController
public class ZerodhaPlatformController {

	@Autowired
	private ZerodhaPlatformConfiguration configurator;

	private static final Logger logger = LoggerFactory.getLogger(ZerodhaPlatformController.class);

	@RequestMapping("/zerodha-platform-details")
	public ZerodhaPlatformConfiguration getZerodhaPlatformConfiguration() {
		if (configurator == null) {
			logger.debug(ZerodhaPlatformConfiguration.class + " configurator is null.");
		} else {
			logger.info("Request received to fetch details... @info");
		}
		return configurator;
	}
}
