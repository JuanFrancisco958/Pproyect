package Orders;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import Clients.RepositoryC;
import Utils.RepositoryUtil;

public class RepositoryO implements Serializable{
	private List<Order> comandas=new ArrayList<>();
	private static RepositoryO instance;
	RepositoryUtil u=new RepositoryUtil();
	
	
	
	private RepositoryO() {
		try {
			comandas=u.importOrders();
		} catch (ClassNotFoundException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	public static RepositoryO getInstance(){
        if(instance==null){
            instance = new RepositoryO();
        }
        return instance;
    }

	public List<Order> getAllOrders() {

		return comandas;
	}
	
	public List<Order> getOrdersByClient(String dni){
		List<Order> result=new ArrayList<>();;
		if (dni!=null) {
			for (Order com : comandas) {
				if (com.getClient().getDni().equals(dni)) {
					result.add(com);
				}
			}
		}
		return result;
	}
	
	public List<Order> getOrdersByDate(LocalDate ini, LocalDate end){
		LocalDateTime inicio = ini.atStartOfDay();
		LocalDateTime fin= end.atStartOfDay();

		List<Order> result=new ArrayList<>();
		if (ini!=null && end!=null) {
			for (Order com : comandas) {
				if (com.getLocalDateTime().isAfter(inicio) && com.getLocalDateTime().isBefore(fin) ) {
					result.add(com);
				}
			}
			
		}
		return result;
	}
	
	public List<Order> getOrdersNoDelivered(){
		List<Order> result=new ArrayList<>();;
		for (Order com : comandas) {
			if (com.isDelivered()==false) {
				result.add(com);
			}
		}
		return result;
		
	}
	
	public List<Order> getOrdersNoPayed(){
		List<Order> result=new ArrayList<>();;
		for (Order com : comandas) {
			if (com.isPayed()==false) {
				result.add(com);
			}
		}
		return result;		
	}
	
	public double getAllInput(){
		double result=0;
			for (Order com : comandas) {
				result+=com.getTotal();
			}
		return result;
		
	}
	
	public double getInputByDate(LocalDate ini, LocalDate end){
		List<Order> comand=getOrdersByDate(ini, end);
		double result=0;
			for (Order com : comand) {
				result+=com.getTotal();
			}
		return result;
		
	}
	public boolean addOrder(Order o) {
		boolean result=false;
		if (o!=null) {
			comandas.add(o);
			o.getClient().addOrder(o);
			u.exportOrders(comandas);
		}
		return result;
	}
	public boolean deleteOrder(Order o) {
		boolean result=false;
		if (o!=null) {
			comandas.remove(o);
			o.getClient().deleteOrder(o);
			u.exportOrders(comandas);
		}
		return result;
	}

}
