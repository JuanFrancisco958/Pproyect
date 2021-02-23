package Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Drink extends Product implements Serializable{
	private boolean alcoholic;
	
	
	public Drink(int id, String name, double price,Integer bundle, boolean forCeliac,boolean alcoholic) {
		super(id, name, price, forCeliac,bundle);
		this.alcoholic=alcoholic;
	}
	
	
	public Drink(int id, String name, double price, boolean forCeliac, boolean alcoholic) {
		super(id, name, price, forCeliac);
		this.alcoholic = alcoholic;
	}



	
	public List<Product> getBundlePack() {
		List<Product> result=new ArrayList<>();
		return result;
	}
	public boolean isAlcoholic() {
		return alcoholic;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public double getPrice() {
		return this.price;
	}
	
	public boolean getItsForCeliac() {
		return isForCeliac();
	}
	
	

	@Override
	public String toString() {
		return super.toString()+"  alcoholic= " + alcoholic + "]";
	}
	
	
}
