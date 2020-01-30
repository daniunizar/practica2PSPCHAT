package socketprueba09;

public class ObjetoLogin {
	boolean logeado = false;
	int intentos = 3;
	
	public void setValorLogeado(boolean valor) {
		logeado = valor;
	}
	public boolean getValorLogeado() {
		return logeado;
	}
	
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	
	public void restarIntento() {
		if (dimeIntentos() > 0) this.intentos --;
	}
	
	public int dimeIntentos() {
		return intentos;
	}
}
