package com.mycompany.caas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.caas.exception.BadRequestException;
import com.mycompany.caas.payload.JwtAuthenticationResponse;
import com.mycompany.caas.payload.LoginRequest;
import com.mycompany.caas.payload.RefreshTokenRequest;
import com.mycompany.caas.security.CustomUserDetailsService;
import com.mycompany.caas.security.JwtTokenProvider;
import com.mycompany.caas.security.UserPrincipal;

/**
 * @author dinesh.lohia
 */

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	JwtTokenProvider tokenProvider;

	@PostMapping("/token")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@PostMapping("/refresh")
	public ResponseEntity<?> refreshAccessToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
		// Get user name by token id
		// Validate against principal
		// If principal found , generate new token,
		// else throw excepation
		throw new BadRequestException("Invalid Refresh Token");
	}

	@SuppressWarnings("unused")
	private void saveRefreshToken(UserPrincipal userPrincipal, String refreshToken) {
		// Persist Refresh Token id and username details
	}
}
