package Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Food extends Product implements Serializable{
	private boolean forVegans;

	public Food(int id, String name, double price, Integer bundle, boolean forCeliac,boolean forVegans) {
		super(id, name, price, forCeliac,bundle);
		this.forVegans=forVegans;
	}
	

	public Food(int id, String name, double price, boolean forCeliac, boolean forVegans) {
		super(id, name, price, forCeliac);
		this.forVegans = forVegans;
	}


	//Métedos Getters and Setters de los atributos
	
	public List<Product> getBundlePack() {
		List<Product> result=new ArrayList<>();
		return result;
	}

	@Override
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	@Override
	public double getPrice() {
		return this.price;
	}
	@Override
	public boolean getItsForCeliac() {
		return this.forCeliac;
	}
	public boolean isForVegans() {
		return isForCeliac();
	}
	
	/**
	 * Metodo para imprimir una comida
	 */
	@Override
	public String toString() {
		return super.toString()+"  forVegans= " + forVegans + "]";
	}
	
}
