package com.lionsbot.sampleapp;

import java.util.UUID;

import com.lionsbot.sampleapp.common.User;

public class UserContext {

	private static final ThreadLocal<User> CONTEXT = new ThreadLocal<>();

	public static void setUser(User user) {
		CONTEXT.set(user);
	}

	public static User getUser() {
		return CONTEXT.get();
	}

	public static UUID loggedInUserID() {
		return CONTEXT.get().getId();
	}

	public static String loggedInUserName() {
		return CONTEXT.get().getUserName();
	}

	public static boolean isAnonymous() {
		return CONTEXT.get() == null;
	}

	public static void clear() {
		CONTEXT.remove();
	}
}
