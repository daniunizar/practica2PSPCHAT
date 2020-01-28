package socketprueba06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Hilo_Servidor extends Thread{
	//constructor
	Socket cliente;
	ObjetoCompartido ob;
	public Hilo_Servidor(Socket cliente, ObjetoCompartido ob) {
		this.cliente = cliente;
		this.ob = ob;
	}

	public void run(){
		InetAddress ia = cliente.getInetAddress();
		InputStream is;
		OutputStream os;
		Boolean validado = false;
		//El cliente debe identificarse con usuario y contraseña
		while (validado==false) {
			try {
				os = cliente.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("Bienvenido. Inserte su nombre de usario, por favor");

				is = cliente.getInputStream();
				DataInputStream dis = new DataInputStream(is);

				String usuario = dis.readUTF();

				dos.writeUTF("Introduzca su contraseña");

				String contra = dis.readUTF();

				if (usuario.equals("Stuka") && contra.equals("mapas")) {
					dos.writeUTF("Bienvenido Stuka, has sido correctamente logueado.");
					validado = true;
				}


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//El cliente identificado participa en el chat
		try {
			is = cliente.getInputStream();		
			DataInputStream dis = new DataInputStream(is);
			String cadena = "";
			while (true) {
				cadena = dis.readUTF();
				System.out.println("Servidor: Recibimos el siguiente mensaje del cliente: "+ ia.getCanonicalHostName() + ": " + cadena);
				//enviar a todos el mensaje recibido
				ArrayList <Socket> miLista = new ArrayList<>();
				miLista = ob.dimeListaUsuarios();
				for(Socket elemento : miLista) {
					Socket cliente = elemento;
					os = cliente.getOutputStream();
					DataOutputStream dos = new DataOutputStream(os);
					dos.writeUTF(cadena);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
