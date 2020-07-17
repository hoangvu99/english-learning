package com.hoangvu.service.iml;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hoangvu.dao.UserRepository;
import com.hoangvu.entity.CustomUserDetails;
import com.hoangvu.entity.Role;
import com.hoangvu.entity.User;

@Service
public class UserDetailServiceImp implements UserDetailsService{

	@Autowired UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.loadUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		Set<GrantedAuthority>authorities = new HashSet<GrantedAuthority>();
		List<Role>roles = user.getRoles();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		user.setActive(true);
		userRepository.save(user);
		return new CustomUserDetails(user);
	}

}
