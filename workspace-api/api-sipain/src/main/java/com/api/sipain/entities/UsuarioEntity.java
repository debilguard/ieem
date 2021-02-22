package com.api.sipain.entities;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
 
/*@SqlResultSetMapping(name = "UsuarioMapping",
		classes = @ConstructorResult(
				targetClass = UsuarioEntity.class,
				columns = {
						@ColumnResult(name = "NombreUsuario"),
						@ColumnResult(name = "Password"),
						@ColumnResult(name = "Nombre")
						}
				) 
		)

@NamedNativeQuery(
		name = "UsuarioEntity.selectUsuario",
		query = "select u.username NombreUsuario,u.password Password,u.nombre Nombre from tsipain_api_usuario u;",
		resultSetMapping = "UsuarioMapping"
		)

@NamedNativeQueries({
    @NamedNativeQuery(
        name = "getAll",
        query = "select u.username NombreUsuario,u.password Password,u.nombre Nombre from tsipain_api_usuario u",
                    resultClass=UsuarioEntity.class
    )
})*/

@NamedNativeQueries({
    @NamedNativeQuery(
        name = "getAll",
        query = "SELECT id, firstName, lastName, email, department.id, department.name " +
                    "FROM employee, department",
                    resultClass=UsuarioEntity.class
    ) 
})
 
@Table (name="TSIPAIN_API_USUARIO")
 
public class UsuarioEntity {
  
	private String Username;
	private String Password; 	
	
	public UsuarioEntity() {}
	public UsuarioEntity(String username, String password) 
	{
		super();
		this.Username = username;
		this.Password = password;
	}
	   	   
}
