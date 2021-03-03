package Controller;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import Clients.Client;
import Clients.RepositoryC;
import Interfacez.IMainMenuController;
import Orders.Order;
import Orders.RepositoryO;
import Products.Drink;
import Products.Repository;
import Utils.RepositoryUtil;
import Vista.Syso;

public class MainMenu implements IMainMenuController{

	public static void main(String[] args) throws ClassNotFoundException  {
		Repository carta=new Repository();
		/*RepositoryC clientes=RepositoryC.getInstance();
		RepositoryO comandas=RepositoryO.getInstance();
		importarC(clientes);
		importarO(comandas);*/
		//Menu();
		//clientes.addClient(new Client("1122334455p", "pepe", 22, "C/bonifacio"));
		//comandas.addOrder(new Order(1,clientes.searchClient("1122334455p"), 4, "C/Bonifacio", false, true));
		//comandas.addOrder(new Order(clientes.searchClient("1122334455p"), 1, 1, "C/Bonifacio", false, true));
				

		/*clientes.getAllClients().forEach(item->System.out.println(item));
		comandas.getAllOrders().forEach(item->System.out.println(item));*/
		
	}
	
	
	public static void Menu() {
		Syso.menuP();
		MainMenu u=new MainMenu();
		RepositoryC c=RepositoryC.getInstance();
		RepositoryO o=RepositoryO.getInstance();
		importarC(c);
		importarO(o);
		switch (getint("Elige una opcion")) {
		case 0:
			u.newOrder(c.searchClient(getString("Introduce Dni:")), LocalDate.now());
			break;
		case 1:
			//u.changeOrder(c);
			break;
		case 2:
			//u.changeOrder(d);
			break;
		case 3:
			//u.changeOrder(c, d);
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			break;
		case 12:
			u.saveAllAndClose();
			break;
		

		default:
			break;
		}
	}
	
	
	
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

	@Override
	public void newOrder(Client c, LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();
		Repository carta=new Repository();
		try {
			o.addOrder(new Order(c, o.getAllOrders().size()+1, carta.searchProduct(getString("Intrduce el nombre del producto: ")).getId(), getString("Introduce la dirreccion"), getBoolean("Introduce si esta entregado: "),getBoolean("Introduce si esta pagado: ") ));
		} catch (Exception e) {
			Syso.print("Error al crea la orden.");
		}
		
	}

	@Override
	public Order changeOrder(Client c) {
		RepositoryO o=RepositoryO.getInstance();

		return null;
	}

	@Override
	public Order changeOrder(LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();

		return null;
	}

	@Override
	public Order changeOrder(Client c, LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();

		return null;
	}

	@Override
	public void deleteOrder(Client c) {
		RepositoryO o=RepositoryO.getInstance();
		
	}

	@Override
	public void deleteOrder(LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();
		
	}

	@Override
	public void deleteOrder(Client c, LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();
		
	}

	@Override
	public Double cashToday() {
		RepositoryO o=RepositoryO.getInstance();
		return null;
	}

	@Override
	public Double cashThisMonht() {
		RepositoryO o=RepositoryO.getInstance();
		return null;
	}

	@Override
	public Double cashTotal() {
		RepositoryO o=RepositoryO.getInstance();		
		return null;
	}

	@Override
	public void viewOrdersNotPayed() {
		RepositoryO o=RepositoryO.getInstance();
		
	}

	@Override
	public void viewOrdersPendingDelivered() {
		RepositoryO o=RepositoryO.getInstance();
		
	}

	@Override
	public void saveAllAndClose() {
		RepositoryC c=RepositoryC.getInstance();
		RepositoryO o=RepositoryO.getInstance();
		exportarC(c);
		exportarO(o);
	}
	public static void printOrders() {
		RepositoryO o=RepositoryO.getInstance();
		o.getAllOrders().forEach(item->System.out.println(item));
	}
	public static void printClients() {
		RepositoryC c=RepositoryC.getInstance();
		c.getAllClients().forEach(item->System.out.println(item));
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
