package com.junit.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.junit.entity.Address;
import com.junit.entity.Employee;
import com.junit.exception.GlobalException;


//keep all our buisness logic //CRUD-Create Read Update Delete //custom methods
public class EmployeeService {
		
	private ArrayList<Employee> empList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	//method to add employee details in array list
	public void addEmployee(int empId,String empName,double salary,String city,String state) {
		Address address=new Address(city,state);
//		Employee emp=new Employee(empId,empName,salary,address);
//		empList.add(emp);
		empList.add(new Employee(empId,empName,salary,address));
	}
	
	//method for testing using builder annotation
	public void addEmp(Employee emp) {
		empList.add(emp);
	}
	
	public int lengthOfList() {
		return empList.size();
		
	}
	
	//method to fetch all the data from arraylist
	public void displayAllEmployees() {
		for(Employee e:empList) {
			System.out.println(e);
		}
	}
	
	//method to get employee details uaing the id
	public Employee displayEmpById(int id) throws GlobalException{
		int i;
		//we will traversing over the elements present in our list
		for(i=0;i<empList.size();i++) {
			if(id==empList.get(i).getEmpId()) {
				return empList.get(i);
			}
		}
		//if the counter variable is same as the size of the list
		//it means that the element we are looking is not present
		if(i==empList.size()) {
			throw new GlobalException("Employee details not found");
		}
		return null;
	}
	
	//method to update employee details uaing the empid
	
	//way1
		public void updateEmpById(int id) throws GlobalException{
			int i;
			//we will traversing over the elements present in our list
			for(i=0;i<empList.size();i++) {
				if(id==empList.get(i).getEmpId()) {
					System.out.println("Enter employee name:");
					
					String name = sc.nextLine();
					System.out.println("Enter salary:");
					double sal = sc.nextDouble();
					sc.nextLine();
					System.out.println("Enter city:");
					String city = sc.nextLine();
					System.out.println("Enter state:");
					String state = sc.nextLine();
					Address add=new Address(city,state);
					empList.set(i, new Employee(id, name, sal, add));
				}
}

			
			//if the counter variable is same as the size of the list
			//it means that the element we are looking is not present 
			if(i==empList.size()) {
				throw new GlobalException("EMployee details not found");
			}
			
		}
		//way 2
		//update employee details
		public Employee update(int index,Employee emp) {
			return empList.set(index, emp);
		}
		
		//method to update an employee using Id
		
		 public Employee updateById(int id,Employee emp,String name) throws GlobalException {
			 for (int i = 0; i < empList.size(); i++) {
				 if(emp.getEmpId()==empList.get(i).getEmpId()) {
					 emp.setEmpName(name);
					return empList.set(i, emp);
				 }
			}
			return null;
		 }
		 
		//method to calculate yearly salary of a employee
		 public double yearlySalaryById(Employee emp,int id) throws GlobalException {
			 double yearlySal=0;
			 int i;
			 for ( i = 0; i < empList.size(); i++) {
				 if(emp.getEmpId()==empList.get(i).getEmpId()) {
					 yearlySal= (emp.getSalary()*12);
					 return yearlySal;
				 }
			}
			 if(i==empList.size()) {
				 throw new GlobalException("Employee not Found");
			 }
			 return yearlySal;
		 }
		 //method to know the apparaisal of employee according to there salary
		 public  int calculateAppraisalById(int id) throws GlobalException {
		     int appraisal=0;
		     for (int i = 0; i < empList.size(); i++) {
		    	 if(id==empList.get(i).getEmpId()) {
		    	  if (empList.get(i).getSalary() >=30000) {
		             appraisal = 3000;
		          } else if (empList.get(i).getSalary()>= 20000) {
		             appraisal = 2000;
		           } else {
		             appraisal = 1000;
		           }
		        }     
			}
		     if(appraisal==0) {
		    	 throw new GlobalException("Employee not Found");
		     }
		     return appraisal;
		 }
			
			
		 //method to remove /delete an employee using id
		 
		 public String deleteByid(int id) throws GlobalException {
			 int i;
			 for ( i = 0; i < empList.size(); i++) {
				 
				 if(id==empList.get(i).getEmpId()) {
				empList.remove(i);
				
				return "Employee removed sucessfully";
				 }
			}
			 
			 if(i==empList.size()) {
				  throw new GlobalException("Employee not Found");
			 }
			return null;
		
		 }
			 //method to delete all the employee
			 public void deleteAllEmp() {
			     for (int i = 0; i < empList.size(); i++) {

					empList.remove(i);
					
					 }
			 }

		
		
}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
