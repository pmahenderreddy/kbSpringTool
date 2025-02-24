package com.mahi.first_rest_api.user;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private UserDetailsRepository repository;

	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(Arrays.toString(args));

		repository.save(new UserDetails("Srisailam", "Admin"));
		repository.save(new UserDetails("Mahender", "User"));
		repository.save(new UserDetails("Ramakrishna", "User"));

		List<UserDetails> users = repository.findAll();
		users.forEach(user -> logger.info(user.toString()));

		logger.info("" + repository.count());

		users = repository.findByRole("User");
		users.forEach(user -> logger.info(user.toString()));

	}
}
