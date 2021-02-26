package com.api.sipain.Utilities;

import com.api.sipain.entities.UserDetailsAuthorization;
import org.springframework.security.core.userdetails.User;

public class UsersDetailExtend extends User {

	private static final long serialVersionUID = 1L;
	   public UsersDetailExtend(UserDetailsAuthorization user) {
	      super(
	    		  user.getUsername(),
	    		  user.getPassword(),
	    		  user.getListOfgrantedAuthorities()
	    		);
	   }
}
