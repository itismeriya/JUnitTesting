package com.junit;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.junit.entity.Calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

	static Calculator cal;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cal = new Calculator();
		System.out.println("Before all will get initialized at first");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		cal = null; //null referencing
		System.out.println("After all will be called at the end");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("this is called before each test case");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("this is called after each test case");
	}
	
	@Test
	@DisplayName("Test addition method")
	void testAddition()
	{
		assertEquals(30, cal.addition(10, 20));
	}
	
//	@Test
//	@DisplayName("Negative test case")
//	void negativeTestCase()
//	{
//		assertEquals(35, cal.addition(10, 20));
//	}
	
	@Test
	void test()
	{
		int num = 7;
		String name = "Deesha";
		String name1 = null;
		
		assertTrue(num<10); //asserting that the condition is true
		
		assertFalse(num>10); //asserting that the condition is false
		
		assertNotNull(name);
		
		assertNull(name1);
		
		assumeTrue(num<10);
		
		assumeFalse(num>10);
		
	}
	
	@Test
	@DisplayName("Testing reverse of a string")
	void reverseOfString()
	{
		System.out.println(cal.reverse("Koyel"));
		assertEquals("leyoK", cal.reverse("Koyel"));
	}
	
	@Test
	void testArithmeticException()
	{
		assertThrows(ArithmeticException.class , 
				()-> cal.division(10, 0));
	}
	
	@Test
	@DisplayName("testing division method")//displays on junit 
	void testDevide() {
		Calculator cal=new Calculator();
		assertThrows(ArithmeticException.class, ()->cal.division(12, 0));
	}
	
	@Test
	@DisplayName("testing factorial method")
	void testFact() {
		Calculator cal=new Calculator();
		assertEquals(120, cal.fact(5),"checks factorial");
	}
	
	
	@Test
	void testCheckMumbai() {
		Calculator cal=new Calculator();
		assertFalse(false,"e");
	}
	
	@Test
	void testCheckI() {
		Calculator cal=new Calculator();
		assertTrue(true,"I");
	}
	
	@Test
	void testLengthOfString() {
		String s="";
		assumeTrue(s.isEmpty());  //assuming this condition has to be true
		//if true the test case will run or else abort
		//and the opp for assumeFalse()
		assertEquals(0, cal.checkLengthOfString(s));
	}
	
	@Test
	void testSearchElementArray() {
		assertEquals(0, cal.searchElementArray(100));
	}
	
	@Test
	void testAddArrayElement()
	{
		assertArrayEquals(new int[] {10,20,30,40,50},
				cal.insertElement(new int[] {10,30,40,50}, 2, 20));
	}
	
	@Test
	@EnabledForJreRange(min = JRE.JAVA_11, max=JRE.JAVA_20)
	void testArithmeticException1()
	{
		assertEquals("Cannot divide a number by zero.", cal.division1(10, 0));
	}
	
	@Test
	@DisabledOnOs(value = {OS.MAC, OS.LINUX})
	@DisabledOnJre(value = {JRE.JAVA_9})
	void testException()
	{
		assertThrows(ArithmeticException.class,
				()-> cal.division2(10, 0));
	}
	
	@Test
	@Disabled
	void testDisable()
	{
		fail("this test case should be disble");
	}
	

}