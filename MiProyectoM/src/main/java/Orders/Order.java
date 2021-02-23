package Orders;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Clients.Client;
import Products.Product;

public class Order implements Serializable{
	private Client client;
	private List<Product> Products=new ArrayList<>();
	private double total;
    LocalDateTime localDateTime = LocalDateTime.now();
	private String address;
	private boolean delivered;
	private boolean payed;
	
	
	private Order() {
	}

	public Order(Client client, Product product,String address, boolean delivered, boolean payed) {
		this.client = client;
		Products.add(product);
		this.address = address;
		this.total=getAllInput();
		this.delivered = delivered;
		this.payed = payed;
	}

	//Metodos Getters y Setters de los atributos
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client c) {
		this.client = c;
	}
	
	public List<Product> getProducts() {
		return Products;
	}
	public void setProducts(List<Product> products){
		this.Products=products;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean isDelivered() {
		return delivered;
	}
	
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
	public boolean isPayed() {
		return payed;
	}
	
	public void setPayed(boolean payed) {
		this.payed = payed;
	}
	
	//Metodos para los productos
	public void addNewProducts(List<Product> products) {
		Products.addAll(products);
	}
	public void clearAllProducts() {
		Products.clear();
	}
	public void addProduct(Product p) {
		Products.add(p);
	}
	public void deleteProduct(Product p) {
		Products.remove(p);
	}
	public double getAllInput() {
		double result=0;
		 if (Products!=null) {
			for (Product item : Products) {
				result+=item.getPrice();
			}
		}
		return result;
	}

	@Override
	/**
	 * Metodo de comparacion entre dos ordenes
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		return true;
	}

	/*
	 *Metodo para Imprimir una orden 
	 */
	@Override
	public String toString() {
		return "Order [client=" + client.getDni() +" "+client.getName() + ", Products=" + Products.size() + ", total=" + total + "€, LocalDateTime="
				+ localDateTime + ", address=" + address + ", delivered=" + delivered + ", payed=" + payed + "]";
	}
	
	
	
}
