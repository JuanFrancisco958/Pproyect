package Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Interfacez.IProduct;

abstract public class Product implements IProduct, Serializable {
	protected int id;
	protected String name;
	protected double price;
	protected boolean forCeliac;
	protected List<Integer> bundle;
	
	public Product(int id, String name, double price, boolean forCeliac, Integer bundle) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.forCeliac = forCeliac;
		this.bundle.add(bundle);
	}
	
	public Product(int id, String name, double price, boolean forCeliac) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.forCeliac = forCeliac;
		this.bundle=new ArrayList<Integer>();
	}
	
	//Métedos Getters and Setters de los atributos

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isForCeliac() {
		return forCeliac;
	}
	public void setForCeliac(boolean forCeliac) {
		this.forCeliac = forCeliac;
	}
	
	
	/**
	 * Metodo para imprimir un producto
	 */
	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", price=" + price + ", forCeliac=" + forCeliac ;
	}
	
	
	
	
	

}
