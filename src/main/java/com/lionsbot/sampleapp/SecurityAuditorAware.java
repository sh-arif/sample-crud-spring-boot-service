package com.lionsbot.sampleapp;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SecurityAuditorAware implements AuditorAware<String> {

	private static final String SYSTEM = "System";

	@Override
	public Optional<String> getCurrentAuditor() {
		if (UserContext.isAnonymous()) {
			return Optional.of(SYSTEM);
		} else {
			return Optional.of(UserContext.loggedInUserName());
		}
	}

}
