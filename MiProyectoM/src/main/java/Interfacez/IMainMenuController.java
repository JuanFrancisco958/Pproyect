package Interfacez;

public interface IMainMenuController {
	void newOrder();
	/*Order changeOrder(Client c);
	Order changeOrder(LocalDate d);
	Order changeOrder(Client c, LocalDate d);
	void deleteOrder(Client c);
	void deleteOrder(LocalDate d);
	void deleteOrder(Client c, LocalDate d);*/
	Double cashToday();
	Double cashThisMonht();
	Double cashTotal();
	void viewOrdersNotPayed();
	void viewOrdersPendingDelivered();
	void saveAllAndClose();

	
}
