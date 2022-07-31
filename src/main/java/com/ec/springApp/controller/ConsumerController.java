package com.ec.springApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import javax.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec.springApp.entites.Consumer;
import com.ec.springApp.payload.JwtResponse;
import com.ec.springApp.payload.MessageResponse;
import com.ec.springApp.security.jwt.JwtUtils;
import com.ec.springApp.security.service.UserDetailsImpl;
import com.ec.springApp.service.ConsumerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	public void addConsumer(@RequestBody Consumer consumer) {
		this.consumerService.addConsumer(consumer);
	}
	
	
	@PostMapping("getConsumer")
	public ResponseEntity<?> authenticateUser(@RequestBody Consumer consumer) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(consumer.getUsername(), consumer.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
//		List<String> roles = userDetails.getAuthorities().stream()
//				.map(item -> item.getAuthority())
//				.collect(Collectors.toList());
		//this.consumerService.addConsumer(consumer);
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody Consumer consumer) {
		if (this.consumerService.existsByUsername(consumer.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		if (this.consumerService.existsByEmail(consumer.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		// Create new user's account
//		Consumer user = new User(consumer.getUsername(), 
//				consumer.getEmail(),
//							 encoder.encode(consumer.getPassword()));
//		Set<String> strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//		if (strRoles == null) {
//			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//			roles.add(userRole);
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//					break;
//				case "mod":
//					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(modRole);
//					break;
//				default:
//					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(userRole);
//				}
//			});
//		}
//		user.setRoles(roles);
		this.consumerService.addConsumer(consumer);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@GetMapping("getConsumers")
	public List<Consumer> findConsumers() {
		return this.consumerService.findAllConsumer();
	}
	
//	@PostMapping("getConsumer")
//	public Consumer findConsumerByUsernameAndPassword(@RequestBody Consumer consumer) {
//		return this.consumerService.findConsumerbyUsernameAndPassword(consumer.getUsername(), consumer.getPassword());
//	}
	
	@PutMapping("updateConsumer")
	public Consumer updateCosumer(@RequestBody Consumer consumer) {
		return this.consumerService.updateCosumer(consumer);
	}
}
