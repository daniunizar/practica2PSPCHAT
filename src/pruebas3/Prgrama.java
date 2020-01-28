package pruebas3;

import java.util.ArrayList;

public class Prgrama {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> miLista = new ArrayList <>();
		miLista.add(0);
		miLista.add(1);
		miLista.add(2);
		miLista.add(3);
		miLista.add(4);
		miLista.add(5);
		int posAle;
		while(miLista.size()>0) {
			posAle = (int) (Math.random()*miLista.size());
			System.out.println(miLista.get(posAle));
			miLista.remove(posAle);
			System.out.println("Tamaño Lista: "+miLista.size());
			
		}
	}

}
