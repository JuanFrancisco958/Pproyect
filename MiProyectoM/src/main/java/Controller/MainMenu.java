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
import Utils.GUI;
import Utils.RepositoryUtil;
import Vista.Syso;

public class MainMenu implements IMainMenuController{

	public static void main(String[] args) throws ClassNotFoundException  {
		Repository carta=new Repository();
		RepositoryC clientes=RepositoryC.getInstance();
		RepositoryO comandas=RepositoryO.getInstance();
		GUI.importarC(clientes);
		GUI.importarO(comandas);
		
		//clientes.addClient(new Client("1122334455p", "pepe", 22, "C/bonifacio"));
		//comandas.addOrder(new Order(1,clientes.searchClient("1122334455p"), 4, "C/Bonifacio", false, true));
		//comandas.addOrder(new Order(clientes.searchClient("1122334455p"), 1, 1, "C/Bonifacio", false, true));
		clientes.getAllClients().forEach(item->System.out.println(item));
		comandas.getAllOrders().forEach(item->System.out.println(item));
		
		//run();
	}
	public static void run() {
		Syso.menuDeBienvenida();
		menuPrincipal();
	}
	public static void menuPrincipal() {
		MainMenu u=new MainMenu();
				
		Syso.menuPrincipal();
		
		switch (GUI.getint("")) {
		case 1:
			menuCartaOferta();
			break;
		case 2:
			menuNuevoPedido();
			break;
		case 3:
			u.menuPedidos();
			break;
		case 4:
			u.menuClientes();
			break;
		case 5:
			u.menuFinanzas();
			break;
		case 6:
			u.saveAllAndClose();
			break;
		case 7:
			Syso.menuDeDespedida();
			break;

		default:
			break;
		}
	}
	
	public static void menuCartaOferta() {
		Syso.menuMenuOferta();
		Repository c=new Repository();

		switch (GUI.getint("")) {
		case 1:
			Syso.printCarta();
			menuCartaOferta();
			break;
		case 2:
			Syso.printF(c.getAllFoods());
			menuCartaOferta();
			break;
		case 3:
			Syso.printD(c.getAllDrinks());
			menuCartaOferta();
			break;
		case 4:
			Syso.printP(c.getBundleProducts());
			menuCartaOferta();
			break;
		case 5:
			menuPrincipal();
			break;

		default:menuPrincipal();
			break;
		}
	}
	public static void menuNuevoPedido() {
		Syso.menuNuevoPedido();
		MainMenu u=new MainMenu();
		RepositoryC c=RepositoryC.getInstance();
		
		switch (GUI.getint("")) {
		case 1:
			u.newOrder(c.searchClient(GUI.getString("Introduce el dni:")), LocalDate.now());
			break;
		case 2:
			u.newClient();
			break;
		case 3:
			
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
		case 9:menuPrincipal();
			break;

		default:menuPrincipal();
			break;
		}
	}
	public static void menuPedidos() {
		Syso.menuPedidosRealizados();
		MainMenu u=new MainMenu();
		RepositoryC c=RepositoryC.getInstance();
		
		switch (GUI.getint("")) {
		case 1:
			Syso.printOrders();
			break;
		case 2:
			u.viewOrdersNotPayed();
			break;
		case 3:
			u.viewOrdersPendingDelivered();
			break;
		case 4:
			u.deleteOrder(c.searchClient(GUI.getString("Introduce dni:")));
			break;
		case 5:
			menuPrincipal();
			break;
		
		default:menuPrincipal();
			break;
		}
	}
	public static void menuClientes() {
		Syso.menuClientes();
		MainMenu u=new MainMenu();
		RepositoryC c=RepositoryC.getInstance();
		
		switch (GUI.getint("")) {
		case 1:
			u.newClient();
			break;
		case 2:
			u.newClient();
			break;
		case 3:
			
			break;
		case 4:
			GUI.exportarC(c);
			break;
		case 5:
			menuPrincipal();
			break;

		default:menuPrincipal();
			break;
		}
	}
	public static void menuFinanzas() {
		Syso.menuFinanzas();
		MainMenu u=new MainMenu();
		RepositoryC c=RepositoryC.getInstance();
		
		switch (GUI.getint("")) {
		case 1:
			u.cashTotal();
			break;
		case 2:
			u.cashThisMonht();
			break;
		case 3:
			u.cashToday();
			break;
		case 4:
			u.cashNoPayed();
			break;
		case 5:
			menuPrincipal();
			break;

		default:menuPrincipal();
			break;
		}
	}
	
	
	public void newClient() {
		RepositoryC c=RepositoryC.getInstance();
		try {
			c.addClient(new Client(GUI.getString("Introduce el dni:"), GUI.getString("Introduce el nombre:"), GUI.getint("Introduce edad:"), GUI.getString("Introduce direccion:")));
		} catch (Exception e) {
			Syso.print("Error al crear al cliente.");
		}
		
	}
	public void cashNoPayed() {
		
	}
	@Override
	public void newOrder(Client c, LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();
		Repository carta=new Repository();
		try {
			o.addOrder(new Order(c, o.getAllOrders().size()+1, carta.searchProduct(GUI.getString("Intrduce el nombre del producto: ")).getId(), GUI.getString("Introduce la dirreccion"), GUI.getBoolean("Introduce si esta entregado: "),GUI.getBoolean("Introduce si esta pagado: ") ));
		} catch (Exception e) {
			Syso.print("Error al crear la orden.");
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
		Syso.printO(o.getOrdersNoPayed());
		
	}

	@Override
	public void viewOrdersPendingDelivered() {
		RepositoryO o=RepositoryO.getInstance();
		Syso.printO(o.getOrdersNoDelivered());
	}

	@Override
	public void saveAllAndClose() {
		RepositoryC c=RepositoryC.getInstance();
		RepositoryO o=RepositoryO.getInstance();
		GUI.exportarC(c);
		GUI.exportarO(o);
	}
	

	
	
}
