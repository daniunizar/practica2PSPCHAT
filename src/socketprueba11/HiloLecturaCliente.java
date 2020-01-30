package socketprueba11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HiloLecturaCliente extends Thread{
	Socket servidor;
	ObjetoLogin objetoLogin;
	String respuestaAlLogin = "";
	public HiloLecturaCliente(Socket servidor, ObjetoLogin objetoLogin) {
		this.servidor = servidor;
		this.objetoLogin = objetoLogin;
	}
	public void run() {
		InetAddress ia= servidor.getInetAddress();
		InputStream is;
		while(objetoLogin.getValorLogeado()==false) {
		try {
			is = servidor.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			respuestaAlLogin = dis.readUTF();
			if (respuestaAlLogin.equals("Login correcto")){
				objetoLogin.setValorLogeado(true);
				while (objetoLogin.getValorLogeado()==true) {
					System.out.println("Cliente Lectura: "+dis.readUTF());
				}
			}else {
				System.out.println("Cliente Lectura: Login incorrecto");
				if (objetoLogin.dimeIntentos()>0) {
					objetoLogin.restarIntento();
					System.out.println("Número de intentos restantes: "+objetoLogin.dimeIntentos());
				}else {
					System.out.println("No le quedan más intentos");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
}
