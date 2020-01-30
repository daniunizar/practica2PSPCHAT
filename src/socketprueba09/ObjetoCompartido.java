package socketprueba09;

import java.net.Socket;
import java.util.ArrayList;

public class ObjetoCompartido {
	ArrayList<Socket> listaUsuarios;
	//m�todo crear lista
	public void crearLista() {
		listaUsuarios = new ArrayList<>();
	}
	public void anadirLista(Socket socket) {
		listaUsuarios.add(socket);
	}
	public int dimeTamanoLista() {
		return listaUsuarios.size();
	}
	public ArrayList<Socket> dimeListaUsuarios() {
		return listaUsuarios;
	}
}
