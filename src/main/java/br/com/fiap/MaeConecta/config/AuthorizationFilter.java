package br.com.fiap.MaeConecta.config;

import br.com.fiap.MaeConecta.model.Login;
import br.com.fiap.MaeConecta.service.security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

	@Autowired
	TokenService tokenService;

	Logger log = LoggerFactory.getLogger(AuthorizationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var token = getToken(request);
		log.info(token);

		if (token != null) {
			Login login = tokenService.getValidateUser(token);
			Authentication auth = new UsernamePasswordAuthenticationToken(login.getEmail(), null,
					login.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}

		filterChain.doFilter(request, response);
	}

	private String getToken(HttpServletRequest request) {
		var header = request.getHeader("Authorization");

		if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) {
			return null;
		}
		log.info(header);
		return header.replace("Bearer ", "");
	}
}
