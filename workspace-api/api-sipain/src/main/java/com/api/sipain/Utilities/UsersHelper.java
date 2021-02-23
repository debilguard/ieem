package com.api.sipain.Utilities;

import org.springframework.security.core.userdetails.User;
import com.api.sipain.entities.UsuarioAutorizado;

public class UsersHelper extends User {

	private static final long serialVersionUID = 1L;
	   public UsersHelper(UsuarioAutorizado user) {
	      super(
	    		  user.getUsername(),
	    		  user.getPassword(),
	    		  user.getListOfgrantedAuthorities()
	    		);
	   }
}
