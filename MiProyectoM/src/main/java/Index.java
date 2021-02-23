import java.time.LocalDateTime;

import Clients.Client;
import Clients.RepositoryC;
import Orders.Order;
import Orders.RepositoryO;
import Products.Repository;
import Utils.RepositoryUtil;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException  {
		RepositoryUtil u=new RepositoryUtil(); 
		Repository carta=new Repository();
		RepositoryC clientes=RepositoryC.getInstance();
		//RepositoryO comandas=RepositoryO.getInstance();
		//clientes.addClient(new Client("1122334455p", "pepe", 22, "C/bonifacio"));
		clientes.getAllClients().forEach(item->System.out.println(item));
		//System.out.println(""+clientes.getAllClients());
		//comandas.getAllOrders().forEach(item->System.out.println(item));
		
	}
	
}
