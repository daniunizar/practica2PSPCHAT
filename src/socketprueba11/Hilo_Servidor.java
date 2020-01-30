package socketprueba11;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		OutputStream osLog;
		try {
			while(true) {
				os = cliente.getOutputStream();//osLog = cliente.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);//DataOutputStream dosLog = new DataOutputStream(osLog);
				is = cliente.getInputStream();		
				DataInputStream dis = new DataInputStream(is);
				String cadena = "";
				//antes del chat normal, validar usuario y clave
				cadena = dis.readUTF();
				String [] partes = cadena.split(" ");
				System.out.println("Nos env�an: "+partes[0] + " - " + partes[1]);
				if (comprobarCredenciales(partes[0], partes[1])){//si las credenciales son correctas...
					dos.writeUTF("Login correcto");//enviamos entero de confirmar conexi�n
					System.out.println("Se ha conectado un usuario");
					try {//chat normal
						//Desde aqu� el funcionamiento normal del chat, lo que reciimos del usuario, lo enviamos a todos los de la lista
						while (true) { 
							System.out.println("Esperando env�os del cliente");
							cadena = dis.readUTF();
							System.out.println("Servidor: Recibimos el siguiente mensaje del cliente: " + cadena);
							//enviar a todos el mensaje recibido
							ArrayList <Socket> miLista = new ArrayList<>();
							miLista = ob.dimeListaUsuarios();
							for(Socket elemento : miLista) {
								Socket cliente = elemento;
								os = cliente.getOutputStream();
								dos = new DataOutputStream(os);
								dos.writeUTF(cadena);
							} //end for
						} //end while
					}//fin del try del chat normal
					catch(Exception e) {
						System.out.println("Alg�n error ocurri� en el chat");
					}//find el catch del chat normal
				}else {//si fallan las crecenciales...
					System.out.println("El cliente ha fallado su login");
					//VOY POR AQU�.
					//SI LAS CREDENCIALES HAN FALLADO, DEBEMOS ENVIAR UNA SOLICITUD DE USUARIO Y CONTRASE�A NUEVAS
					//Y HACER EL CONTADOR
					//PUEDE QUE TENGAMOS QUE ESCRIBIR AL HILO ESCRITURA CLIENTE, NO AL DE LECTURA... PARA ESTO DE LOS 3 INTENTOS
					dos.writeUTF("Log Incorrecto");
				}
			} //end try login
		}//end while
		catch (IOException e) {
			System.out.println("Error en el login");
		} // end catch login

	} //end run


	//M�todo comprobaci�n crecenciales o Login
	public boolean comprobarCredenciales(String nombreComprobar, String claveComprobar) throws IOException {
		File ruta = new File ("./src/socketprueba10/usuarios.txt");
		FileReader fr = new FileReader(ruta);
		BufferedReader br = new BufferedReader(fr);
		String linea="";
		boolean logCorrecto = false;

		while ((linea = br.readLine()) != null) {
			System.out.println(linea);
			String [] partes = linea.split(" ");
			System.out.println(partes[0]);
			System.out.println(partes[1]);
			if(nombreComprobar.equals(partes[0]) && claveComprobar.equals(partes[1])) {
				logCorrecto=true;
			}
		}

		return logCorrecto;
	}


}
