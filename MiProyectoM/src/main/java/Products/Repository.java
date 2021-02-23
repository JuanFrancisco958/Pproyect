package Products;

import java.util.ArrayList;
import java.util.List;

import Interfacez.IProduct;

public class Repository {
		private List<Product> carta=new ArrayList<>();
		

		public Repository() {
			carta.add(new Drink(1,"Fanta", 1.2, true, false));
			carta.add(new Drink(2,"Raddler", 1.1, true, true));
			carta.add(new Drink(3,"Agua", 0.8, true, false));
			carta.add(new Food(4,"Durum", 1, false, false));
			carta.add(new Food(5, "Pizza Vegana", 4.5, true, true));
			carta.add(new Food(6,"Kebah", 1.5, true, false));
			System.out.println("Numero de Productos: "+carta.size());
		}

		
		  public List<Product> getAllProducts() {
			  return carta;
		  }
	
		  public List<Drink> getAllDrinks() {
			  List<Drink> result=new ArrayList<>();
			  for (Product item : carta) {
				  if (item instanceof Drink) {
					result.add((Drink) item);
				}
				
			}
		    return result;
		  }
	
		  public List<Food> getAllFoods() {
			  List<Food> result=new ArrayList<>();
			  for (Product item : carta) {
				  if (item instanceof Food) {
					result.add((Food) item);
				}
				
			}
		    return result;
		  }
	
		  public List<Drink> getAllNoAlcoholicDrinks() {
			  List<Drink> result=new ArrayList<>(); 
			  for (Drink item : getAllDrinks()) {
				  if (!item.isAlcoholic()) {
					result.add(item);
				}
				
			}
		    return result;
		  }
	
		  public List<Drink> getAllAlcoholicsDrinks() {
			  List<Drink> result=new ArrayList<>(); 
			  for (Drink item : getAllDrinks()) {
				  if (item.isAlcoholic()) {
					result.add(item);
				  }
				
			  }
		    return result;
		  }
	
		  public List<Food> getAllForVeganFood() {
			  List<Food> result=new ArrayList<>(); 
			  for (Food item : getAllFoods()) {
				  if (item.isForVegans()) {
					result.add(item);
				  }
				
			  }
		    return result;
		  }
	
		  public List<Product> getBundleProducts(Product p) {
		    // TODO Auto-generated method stub
		    return null;
		  }
	
		  public Product searchProduct(String name) {
			  Product result = null;
			  for (Product item : carta) {
				  if (item.getName().equals(name)) {
					  result=item;
				  }
				
			  }
		    return result;
		  }
	
		  public Drink searchDrinks(String name) {
		    Drink result=(Drink)searchProduct(name);
		    return result;
		  }
	
		  public Food searchFoods(String name) {
		    Food result=(Food)searchProduct(name);
		    return result;
		  }
		  public int getSize() {
			  int result=carta.size();
			  return result;
		  }

		@Override
		public String toString() {
			return "Repository [carta=" + carta + "]";
		}
	
		  
		
	
	
}
