package com.api.sipain.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

public class Usuarios {
	private List<Usuario> usuariosList = new ArrayList<Usuario>();
	public void setusuariosList(ArrayList<Usuario> users) {
		this.usuariosList = users;
	}
	public List<Usuario> getusuariosList() {
		return usuariosList;
	}
}
