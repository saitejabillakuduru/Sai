package com.sysintelli.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysintelli.dao.EmployeeDAO;
import com.sysintelli.entity.Employee;

public class Application {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
 EmployeeDAO e=(EmployeeDAO) context.getBean("Emp");
 Employee em=(Employee) context.getBean("em");
 List<Employee>Ems= new ArrayList<Employee>();
 Ems =e.getAllEmployees();
 for( Employee et:Ems){
	 System.out.println("ID:"+et.getId());
	 System.out.println("name :"+et.getName());
	 System.out.println("salary :"+et.getSalary());
 }
 /*int id=em.getId();*/
//select by id
/*Employee ea=e.getEmployeeByID(id);
System.out.println("id:"+ea.getId());
System.out.println("name:"+ea.getName());
System.out.println("salary:"+ea.getSalary());*/
//inserted
 //e.addEmployee(em);
	//deleted
 //int id=empid;
 //e.deleteEmployeeByID(id));
	
	}
}




 







