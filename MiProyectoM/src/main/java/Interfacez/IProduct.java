package Interfacez;

import java.util.List;

import Products.Product;

public interface IProduct {
	List<Product> getBundlePack();
	String getName();
	double getPrice();
	boolean getItsForCeliac();
	
}
