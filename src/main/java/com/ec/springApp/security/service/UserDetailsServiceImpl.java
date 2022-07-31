package com.ec.springApp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec.springApp.entites.Consumer;
import com.ec.springApp.repository.IConsumerRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IConsumerRepository consumerRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Consumer user = this.consumerRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return UserDetailsImpl.build(user);
	}
}