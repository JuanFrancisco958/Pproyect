package Controller;
import java.time.LocalDate;

import Clients.Client;
import Clients.RepositoryC;
import Interfacez.IMainMenuController;
import Orders.Order;
import Orders.RepositoryO;
import Products.Repository;
import Utils.GUI;
import Vista.Syso;

public class MainMenu implements IMainMenuController{

	public static void main(String[] args) throws ClassNotFoundException  {
		//Repository carta=new Repository();
		RepositoryC clientes=RepositoryC.getInstance();
		RepositoryO comandas=RepositoryO.getInstance();
		GUI.importarC(clientes);
		GUI.importarO(comandas);
		

		//clientes.addClient(new Client("31009229P", "juan", 19, "C/bonifacio"));
		//comandas.getAllOrders().get(comandas.getAllOrders().size()-1).getId()+1;
		//comandas.addOrder(new Order(clientes.searchClient("31009229P"), 2, 2, "C/Bonifacio", false, true));
		clientes.getAllClients().forEach(item->System.out.println(item));
		comandas.getAllOrders().forEach(item->System.out.println(item));
		
		/*GUI.exportarC(clientes);
		GUI.exportarO(comandas);*/
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
			menuPedidos();
			break;
		case 4:
			menuClientes();
			break;
		case 5:
			menuFinanzas();
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
		Repository carta=new Repository();
		RepositoryC c=RepositoryC.getInstance();
		RepositoryO o=RepositoryO.getInstance();
		
		switch (GUI.getint("")) {
		case 1:
			u.newOrder(c.searchClient(GUI.getDni()), LocalDate.now());
			break;
		case 2:
			u.newClient();
			u.newOrder(c.searchClient(GUI.getDni()), LocalDate.now());
			break;
		case 3:
			o.getAllOrders().get(o.getAllOrders().size()-1).addProduct(carta.searchProduct("Introduce el id del producto").getId());
			break;
		case 4:
			GUI.exportarO(o);
			break;
		case 5:
			o.getAllOrders().get(o.getAllOrders().size()-1).getTotal();
			break;
		case 6:
			u.deleteOrder(c.searchClient(GUI.getDni()));
			break;
		case 7:menuPrincipal();
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
			u.deleteOrder(c.searchClient(GUI.getDni()));
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
			c.searchClient(GUI.getDni()).setAge(GUI.getAge());
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
			c.addClient(new Client(GUI.getDni(), GUI.getString("Introduce el nombre:"), GUI.getAge(), GUI.getString("Introduce direccion:")));
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
			o.addOrder(new Order(c, o.getAllOrders().get(o.getAllOrders().size()-1).getId()+1, carta.searchProduct(GUI.getString("Intrduce el nombre del producto: ")).getId(), GUI.getString("Introduce la dirreccion"), GUI.getBoolean("Introduce si esta entregado: "),GUI.getBoolean("Introduce si esta pagado: ") ));
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
