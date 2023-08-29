package com.junit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString

public class Employee {
	private int empId;
	private String empName;
	private double salary;
	private Address address;	//entity reference
}
