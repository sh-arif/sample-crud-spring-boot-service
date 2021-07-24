package com.lionsbot.sampleapp.common;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private UUID id;
	private String token;
	private String email;
	private String userName;
	private List<String> roles;
	private List<String> privileges;
}
