package com.api.sipain.entities;

import java.util.ArrayList;
import java.util.List;

public class Transacciones {
	private List<Transaccion> transaccionList = new ArrayList();
	
	public List<Transaccion> getTransaccionList() {
		return transaccionList;
	}
	
	public void setTransaccionList(List<Transaccion> transaccionList) {
		this.transaccionList = transaccionList;
	}
}
