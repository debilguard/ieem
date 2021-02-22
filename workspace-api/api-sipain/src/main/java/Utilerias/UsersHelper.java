package Utilerias;

import org.springframework.security.core.userdetails.User;
import com.api.sipain.entities.UsuariosAutorizados;

public class UsersHelper extends User {

	private static final long serialVersionUID = 1L;
	   public UsersHelper(UsuariosAutorizados user) {
	      super(
	    		  user.getUsername(),
	    		  user.getPassword(),
	    		  user.getListOfgrantedAuthorities()
	    		);
	   }
}
