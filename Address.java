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

public class Address {
	private String city;
	private String state;
}
