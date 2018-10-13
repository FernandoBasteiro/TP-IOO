package model;
import java.util.*;

public class CuentaCorriente {
	private float saldo;
	private Vector<Movimiento> movimientos;
	
	public CuentaCorriente() {
		saldo = 0;
	}
	
	public void SetSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void ProcesarMovimiento (Date fecha, String concepto, float monto) {
		int numero = movimientos.size() + 1;
		this.saldo = this.saldo + monto;
		Movimiento m = new Movimiento(numero, fecha, concepto, monto);
		movimientos.add(m);
	}
	
	public float GetSaldo() {
		return saldo;
	}
}
