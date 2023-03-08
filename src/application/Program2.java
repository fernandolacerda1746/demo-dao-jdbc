package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department 'findById' =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: findAll =======");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			
			System.out.println(d);
			
		}
		
		System.out.println("\n=== TEST 3: Department 'Insert' =======");
		Department newDepartment = new Department("Furntime");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id: " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department 'Update' =======");
		Department dep2 = departmentDao.findById(11);
		dep2.setName("Pets");
		departmentDao.update(dep2);
		System.out.println("Update Completed");
		
		System.out.println("\n=== TEST 5: delete =======");
		int id = 9;
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

	}

}
