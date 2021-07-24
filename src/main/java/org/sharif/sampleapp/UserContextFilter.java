package org.sharif.sampleapp;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharif.sampleapp.common.User;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class UserContextFilter extends OncePerRequestFilter {

	private final Logger LOGGER = LoggerFactory.getLogger(UserContextFilter.class);

	@Value("${jwt.secret:n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf}")
	private String secret;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String value = request.getHeader("Authorization");
		LOGGER.error("************** Authorization header *********** : " + value);
		if (!StringUtils.isEmpty(value)) {
			User user = getUserFromToken(value.replace("Bearer", "").trim());
			LOGGER.error("User found: " + user);
			UserContext.setUser(user);
		}
		try {
			filterChain.doFilter(request, response);
		} finally {
			UserContext.clear();
		}
	}

	private User getUserFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return User.builder().email(claims.getSubject()).userName((String) claims.get("name"))
				.id(UUID.fromString((String) claims.get("id"))).build();
	}

	@Override
	protected boolean isAsyncDispatch(final HttpServletRequest request) {
		return false;
	}

	@Override
	protected boolean shouldNotFilterErrorDispatch() {
		return false;
	}
}
