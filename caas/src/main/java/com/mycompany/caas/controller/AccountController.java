package com.mycompany.caas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.caas.payload.AccountResponse;
import com.mycompany.caas.security.CurrentUser;
import com.mycompany.caas.security.UserPrincipal;

/**
 * @author dinesh.lohia
 */

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@GetMapping("/balance")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getBalance(@CurrentUser UserPrincipal principal) {
		// Get account details from account service by username. -- principal
		return ResponseEntity.ok(new AccountResponse(10000l));
	}
}
