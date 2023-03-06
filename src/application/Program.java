package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 01: Seller 'findById' ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 02: Seller 'findByDepartment' ===");
		Department department = new Department(2);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			
			System.out.println(obj);
			
		}
		
		System.out.println("\n=== TEST 03: Seller 'findAll' ===");
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			
			System.out.println(obj);
			
		}
	
		System.out.println("\n=== TEST 04: Seller 'Insert' ===");
		Seller newSeller = new Seller(null, "Greg Cyan", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 05: Seller 'Update' ===");
		seller = sellerDao.findById(1);
		seller.setName("Mario Wayne");
		sellerDao.update(seller);
		System.out.println("Updated Complete!");

	}

}
