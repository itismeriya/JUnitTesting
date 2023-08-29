package com.junit.servicetest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.junit.entity.Address;
import com.junit.entity.Employee;
import com.junit.exception.GlobalException;
import com.junit.service.EmployeeService;



//import lombok.Value;
@TestMethodOrder(value=OrderAnnotation.class)

public class EmployeeServiceTest {
	static EmployeeService empService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		empService = new EmployeeService();
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		empService = null; //null referencing
	}
	
	@Test
	@Order(1)
	void testAddEmployee() {
//	//way1

//		empService.addEmployee(101,"Koyel",20000,"Kolkata","WB");
//		empService.addEmployee(111,"Uryaswi",10000,"Chennai","Kerala");
//		assertNotNull(empService.lengthOfList());
//		assertEquals(2, empService.lengthOfList());
//		assertThat(empService.lengthOfList()).isEqualTo(2);
//		assertThat(empService.lengthOfList()>0).isTrue();

	//way 2
	Address add1=Address.builder().city("Kolkata").state("WB").build();
	System.out.println(add1.getCity());
	Employee emp1=Employee.builder().empId(101).empName("Koyel").salary(20000).address(add1).build();
	empService.addEmp(emp1);
	Address add2 = Address.builder().city("Kolkata").state("WB").build();
	Employee emp2 = Employee.builder().empId(111).empName("Uryaswi").salary(40000).address(add2).build();

	empService.addEmp(emp2);
	assertEquals(2,empService.lengthOfList());
//	assertThat(empService.lengthOfList()>0).isTrue();
	
	
}

@Test
@Order(2)
void testDisplayAllEmployee() {
	empService.displayAllEmployees();
	assertEquals(2,empService.lengthOfList());
}

@Test
@Order(3)
void testDisplayEmployeeById() throws GlobalException {
	Employee emp2=empService.displayEmpById(101);
	
	assertEquals("Koyel",emp2.getEmpName());
}

//@Test
//@Disabled
//void testUpdateEmpById() throws GlobalException {
//	
//	empService.updateEmpById(101);
//	assertEquals("Koyel Ghosh",empService.displayEmployeeById(101).getEmpName());
//}

@Test
@Order(4)
void testUpdate() throws GlobalException {
	Employee emp=empService.displayEmpById(101);
	emp.setEmpName("Koyel Ghosh");
	empService.update(1, emp);
	assertEquals("Koyel Ghosh",emp.getEmpName());
}
@Test
	@Order(5)
	void testUpdateById()throws GlobalException{
		
		Employee emp=empService.updateById(1, empService.displayEmpById(101),"Koyel");
		assertEquals("Koyel",emp.getEmpName());
	}

@Test
@Order(7)
//@Disabled
	void TestYearlyEmpSalary() throws GlobalException {
		Employee emp=empService.displayEmpById(101);
		System.out.println(empService.yearlySalaryById(emp, 101));
		assertEquals(348000,empService.yearlySalaryById(emp, 101));
	}

@Test
@Order(8)
void TestcalculateAppraisalById() throws GlobalException {
	assertEquals(2000,empService.calculateAppraisalById(101));
	System.out.println(empService.calculateAppraisalById(101));
}



@Test
@Order(6)
	void testDeleteEmpById() throws GlobalException {
		assertEquals("Employee removed sucessfully",empService.deleteByid(101));
	}

@Test
@Order(9)

void testdeleteAllEmp() {
	empService.deleteAllEmp();
	assertEquals(0,empService.lengthOfList());
	
}
	
}


	

