package Utils;

import java.util.Scanner;

import Clients.RepositoryC;
import Orders.RepositoryO;
import Vista.Syso;

public class GUI {
	/**
	 * Obtener un entero introducido por teclado
	 * @param frase Texto con la informacion deseada.
	 * @return devuelve un entero introducido por teclado
	 */
	public static int  getint(String frase) {
		Scanner teclado=new Scanner(System.in);
		int result=-1;
		
		try {
			Syso.print(frase);
			result=teclado.nextInt();
		} catch (Exception e) {
			Syso.print("Error al obtener entero.");
		}
		return result;
	}

	/***
	 * Obtener una cadena de caracteres.
	 * @param frase Texto con la informacion deseada.
	 * @return devuelve un string introducido por teclado
	 */
	public static String  getString(String frase) {
		Scanner teclado=new Scanner(System.in);
		String result=null;
		
		if (result==null) {
			try {
				Syso.print(frase);
				result=teclado.nextLine();
			} catch (Exception e) {
				Syso.print("Error al obtener string.");
			}
		}
		
		return result;
	}
	/**
	 * 
	 * @param frase Texto con la informacion deseada.
	 * @return devuelve un boleano a decisión del usuario.
	 */
	public static Boolean  getBoolean(String frase) {
		Scanner teclado=new Scanner(System.in);
		Boolean result=null;
		
		if (result==null) {
			try {
				Syso.print(frase);
				Syso.print("0=true 1=false");

				if (teclado.nextInt()==1) {
					result=true;
				}else {
					result=false;
				}
			} catch (Exception e) {
				Syso.print("Error al obtener booleano.");
			}
		}
		
		return result;
	} 
	public static void exportarC(RepositoryC c) {
		RepositoryUtil.saveFile(c.getInstance());
	}
	public static void exportarO(RepositoryO o) {
		RepositoryUtil.saveFileO(o.getInstance());
	}
	public static void importarC(RepositoryC c) {
		c.setClientes(RepositoryUtil.loadFile());
	}
	public static void importarO(RepositoryO o) {
		o.setcomandas(RepositoryUtil.loadFileO());
	}

}
