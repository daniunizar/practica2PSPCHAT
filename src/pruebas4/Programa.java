package pruebas4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> listaAtaquesIA = new ArrayList();
		for (int i=1; i<9; i++) {
			listaAtaquesIA.add(i);
		}
		System.out.println("Mostramos el contenido de la lista");
		Iterator iterator = listaAtaquesIA.iterator();
		while(iterator.hasNext()) {
			int x = (int) iterator.next();
			System.out.print(x+" ");
		}
		
		//Creamos una array con posiciones
		int posicionesBarcos [] = {3, 2, 8};
		// atacamos una posicion
		while(listaAtaquesIA.size()>0) {
		int posicionAtacada = (int) (Math.random()*listaAtaquesIA.size());
		System.out.println("La posicion atacada es "+posicionAtacada + " y se corresponde con el número "+listaAtaquesIA.get(posicionAtacada));
		boolean diana = false;
		
		for (int i=0; i<posicionesBarcos.length; i++) {
			if (listaAtaquesIA.get(posicionAtacada)==posicionesBarcos[i]) {
				diana = true;
			}
		}
		if (diana==true) {
			System.out.println("Barco hundido");
			
		}else {
			System.out.println("agua");
		}
		System.out.println("Eliminamos la posición");
		listaAtaquesIA.remove(posicionAtacada);
		System.out.println("Mostramos el contenido de la lista");
		Iterator iterator2 = listaAtaquesIA.iterator();
		while(iterator2.hasNext()) {
			int x = (int) iterator2.next();
			System.out.print(x+" ");
		}
	}
	}
}
