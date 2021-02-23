package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Clients.Client;
import Clients.RepositoryC;
import Orders.Order;
import Products.Repository;

public class RepositoryUtil{
	public void saveFile(RepositoryC r) {
		//marshaling
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryC.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the list in console
		    //jaxbMarshaller.marshal(_instance, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(r, new File("clients.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
	}
	public List<Client> loadFile() {
		List<Client> result=new ArrayList<Client>();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryC.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    //We had written this file in marshalling example
		    RepositoryC newR = (RepositoryC) jaxbUnmarshaller.unmarshal( new File("clients.xml") );
		    result=newR.getAllClients();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
		public void exportClients(List<Client> clientes) {
		try {
			FileOutputStream f=new FileOutputStream("Clients.txt");
			ObjectOutputStream of=new ObjectOutputStream(f);
			of.writeObject(clientes); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Client> importClients() throws ClassNotFoundException {
		List<Client> result=new ArrayList<>();
		try {
			FileInputStream fi=new FileInputStream("Clients.txt");
			ObjectInputStream iof=new ObjectInputStream(fi);
			result=(List) iof.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		};
		return result;
	}
	public void exportOrders(List<Order> comandas) {
		try {
			FileOutputStream f=new FileOutputStream("Orders.txt");
			ObjectOutputStream of=new ObjectOutputStream(f);
			of.writeObject(comandas);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Order> importOrders() throws ClassNotFoundException {
		List<Order> result=new ArrayList<>();
		try {
			FileInputStream fi=new FileInputStream("Orders.txt");
			ObjectInputStream iof=new ObjectInputStream(fi);
			result=(List) iof.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		};
		return result;
	}
	
}
