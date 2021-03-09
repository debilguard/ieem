package com.api.sipain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.api.sipain.Utilities.UsersDetailExtend;
import com.api.sipain.entities.UserDetailsAuthorization;
import com.api.sipain.repository.UserDetailsRepository;

@Service
public class UserDetailDetailService implements UserDetailsService {

	   @Autowired
	   UserDetailsRepository userDetailsRepository;

	   @Override
	   public UsersDetailExtend loadUserByUsername(final String username) throws UsernameNotFoundException {
		   UserDetailsAuthorization usersDetailsAuthorization = null;
	      try {
	    	  usersDetailsAuthorization = userDetailsRepository.getUserDetails(username);
	    	  UsersDetailExtend userDetail = new UsersDetailExtend(usersDetailsAuthorization);
	         return userDetail;
	      } catch (Exception e) {
	         e.printStackTrace();
	         throw new UsernameNotFoundException("User " + username + " was not found in the database");
	      }
	   } 
}
