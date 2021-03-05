package Vista;

import java.util.List;

import Clients.Client;
import Clients.RepositoryC;
import Orders.Order;
import Orders.RepositoryO;
import Products.Drink;
import Products.Food;
import Products.Product;
import Products.Repository;

public class Syso {
	public static void menuP() {
		System.out.println("+-----------------------------------------+");
		System.out.println("|  Menu Principal                         |");
		System.out.println("|                                         |");
		System.out.println("|  0º Nueva Orden                         |");
		System.out.println("|  1º Cambiar Orden(Cliente)              |");
		System.out.println("|  2º Cambiar Orden(Tiempo)               |");
		System.out.println("|  3º Cambiar Orden(Cliente, Tiempo)      |");
		System.out.println("|  4º Borrar Orden(Cliente)               |");
		System.out.println("|  5º Cambiar Orden(Tiempo)               |");
		System.out.println("|  6º Cambiar Orden(Cliente, Tiempo)      |");
		System.out.println("|  7º Cash Dia                            |");
		System.out.println("|  8º Cash Mes                            |");
		System.out.println("|  9º Cash Total                          |");
		System.out.println("|  10º Ver Ordenes no pagadas             |");
		System.out.println("|  11º Ver Ordenes no entregadas          |");
		System.out.println("|  12º Guardar y cerrar                   |");
		System.out.println("+-----------------------------------------+");

	}
	
	public static void menuDeBienvenida() {
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Bienvenido a su programa RestaurantGestor v1.0 |");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Para gestionar su restaurante de la forma mas  |");
		System.out.println("|  eficiente posible.                             |");
		System.out.println("|  Aplicacion realizada por:                      |");
		System.out.println("|  - Juan F. Aguilar                              |");
		System.out.println("|  - Raul Tenllado                                |");
		System.out.println("|  - Nicolas R. Ramirez                           |");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Cargando programa...                           |");
		System.out.println("|                                                 |");
		System.out.println("|  Pulse Intro...                                 |");
		System.out.println("|                                                 |");
		System.out.println("+-------------------------------------------------+");
	}
	public static void menuPrincipal() {
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Menu Principal                                 |");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Eliga un numero para accedear a:               |");
		System.out.println("|                                                 |");
		System.out.println("|  - 1: Ver Carta del Restaurante y Ofertas:      |");
		System.out.println("|                                                 |");
		System.out.println("|  - 2: Realizar un Nuevo Pedido:                 |");
		System.out.println("|                                                 |");
		System.out.println("|  - 3: Menu Pedidos :                            |");
		System.out.println("|                                                 |");
		System.out.println("|  - 4: Menu Clientes:                            |");
		System.out.println("|                                                 |");
		System.out.println("|  - 5: Menu Finanzas:                            |");
		System.out.println("|                                                 |");
		System.out.println("|  - 6: Guardar Cambios:                          |");
		System.out.println("|                                                 |");
		System.out.println("|  - 7: Salir del Programa:                       |");
		System.out.println("+-------------------------------------------------+");


	}
	
	public static void menuMenuOferta() {
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Menu de Carta y Ofertas                        |");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Eliga un numero para realizar una accion:      |");
		System.out.println("|                                                 |");
		System.out.println("|  - 1: Ver todos los Productos:                  |");
		System.out.println("|                                                 |");
		System.out.println("|  - 2: Ver solo Platos:                          |");
		System.out.println("|                                                 |");
		System.out.println("|  - 3: Ver solo Bebidas:                         |");
		System.out.println("|                                                 |");
		System.out.println("|  - 4: Ver Ofertas de Menus:                     |");
		System.out.println("|                                                 |");
		System.out.println("|  - 5: Volver al Menu Principal:                 |");
		System.out.println("+-------------------------------------------------+");
	}
	public static void menuNuevoPedido() {
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Menu de Nuevo Pedido                           |");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Eliga un numero para realizar una accion:      |");
		System.out.println("|                                                 |");
		System.out.println("|  - 1: Añadir a un Cliente Existente:            |");
		System.out.println("|                                                 |");
		System.out.println("|  - 2: Añadir a un Nuevo Cliente:                |");
		System.out.println("|                                                 |");
		System.out.println("|  - 3: Añadir Producto al Nuevo Pedido:          |");
		System.out.println("|                                                 |");
		System.out.println("|  - 4: Añadir Oferta de Menu al Nuevo Pedido:    |");
		System.out.println("|                                                 |");
		System.out.println("|  - 5: Modificar el Nuevo Pedido:                |");
		System.out.println("|                                                 |");
		System.out.println("|  - 6: Ver total del Nuevo Pedido:               |");
		System.out.println("|                                                 |");
		System.out.println("|  - 7: Eliminar Nuevo Pedido:                    |");
		System.out.println("|                                                 |");
		/*System.out.println("|  - 8: Guardar Nuevo Pedido como Orden:          |");
		System.out.println("|                                                 |");*/
		System.out.println("|  - 9: Volver al Menu Principal:                 |");
		System.out.println("+-------------------------------------------------+");
	}
	public static void menuPedidosRealizados() {
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Menu de Pedidos                                |");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Eliga un numero para realizar una accion:      |");
		System.out.println("|                                                 |");
		System.out.println("|  - 1: Ver todos los Pedidos:                    |");
		System.out.println("|                                                 |");
		System.out.println("|  - 2: Ver Pedidos no pagados:                   |");
		System.out.println("|                                                 |");
		System.out.println("|  - 3: Ver Pedidos no entregados:                |");
		System.out.println("|                                                 |");
		System.out.println("|  - 4: Borrar Pedidos de un Cliente:             |");
		System.out.println("|                                                 |");
		System.out.println("|  - 5: Volver al Menu Principal:                 |");
		System.out.println("+-------------------------------------------------+");
	}
	public static void menuClientes() {
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Menu de Nuevos Clientes                        |");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Eliga un numero para realizar una accion:      |");
		System.out.println("|                                                 |");
		System.out.println("|  - 1: Añadir nuevo cliente:                     |");
		System.out.println("|                                                 |");
		System.out.println("|  - 2: Añadir Direccion:                         |");
		System.out.println("|                                                 |");
		System.out.println("|  - 3: Añadir Edad:                              |");
		System.out.println("|                                                 |");
		System.out.println("|  - 4: Guardar Nuevo Cliente:                    |");
		System.out.println("|                                                 |");
		System.out.println("|  - 5: Volver al Menu Principal:                 |");
		System.out.println("+-------------------------------------------------+");
	}
	
	public static void menuFinanzas() {
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Menu Finanzas                                  |");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Eliga un numero para accedear a:               |");
		System.out.println("|                                                 |");
		System.out.println("|  - 1: Ver Ganancias Totales:                    |");
		System.out.println("|                                                 |");
		System.out.println("|  - 2: Ver Ganancias por Mes:                    |");
		System.out.println("|                                                 |");
		System.out.println("|  - 3: Ver Ganancias por Día:                    |");
		System.out.println("|                                                 |");
		System.out.println("|  - 4: Ver Dinero no cobrado de los pedidos:     |");
		System.out.println("|                                                 |");
		System.out.println("|  - 5: Volver al Menu Principal:                 |");
		System.out.println("+-------------------------------------------------+");


	}
	public static void menuDeDespedida() {
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  Apagando Programa Restaurante                  |");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|                                                 |");
		System.out.println("|  Cerrando programa...                           |");
		System.out.println("|                                                 |");
		System.out.println("|  Cerrado.                                       |");
		System.out.println("|                                                 |");
		System.out.println("+-------------------------------------------------+");


	}
	public static void printOrders() {
		RepositoryO o=RepositoryO.getInstance();
		o.getAllOrders().forEach(item->System.out.println(item));
	}
	public static void printClients() {
		RepositoryC c=RepositoryC.getInstance();
		c.getAllClients().forEach(item->System.out.println(item));
	}
	public static void printCarta() {
		Repository c=new Repository();
		c.getAllProducts().forEach(item->System.out.println(item));
	}
	public static void print(String frase) {
		System.out.println(frase);
	}
	public static void printC(List<Client> c) {
		c.forEach(item->System.out.println(item));
	}
	public static void printO(List<Order> c) {
		c.forEach(item->System.out.println(item));
	}
	public static void printP(List<Product> c) {
		c.forEach(item->System.out.println(item));
	}public static void printF(List<Food> c) {
		c.forEach(item->System.out.println(item));
	}
	public static void printD(List<Drink> c) {
		c.forEach(item->System.out.println(item));
	}
	public static void printI(List<Integer> c) {
		c.forEach(item->System.out.println(item));
	}
}
