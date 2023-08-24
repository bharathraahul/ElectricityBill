package com.cg.electricitybilling.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.context.annotation.Import;

import com.cg.electricitybilling.entity.Customer;

import jakarta.persistence.EntityManager;

@DataJpaTest

@Import(CustomerServiceImpl.class)

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class CustomerServiceImplTest {

	@Autowired

	private CustomerService custService;

	@Autowired

	private EntityManager eManager;

	@BeforeAll

	static void setUpBeforeClass() throws Exception {

		System.out.println("setupbeforeclass");

	}

	@AfterAll

	static void tearDownAfterClass() throws Exception {

		System.out.println("teardownafterclass");

	}

	@BeforeEach

	void setUp() throws Exception {

		System.out.println("setup");

	}

	@AfterEach

	void tearDown() throws Exception {

		System.out.println("teardown");

	}

	@Test

	void testAdd() {

		Customer cust = new Customer(1234, "Sarthak", "xyz986543l", 7697833l, 7896, "abc@gamil.com", "password");

		eManager.persist(cust);

		Customer c = custService.add(cust);

		assertEquals(cust.getName(), c.getName());

	}

	@Test

	void testFindAll() {

		List<Customer> cust = custService.findAll();

		assertTrue(!cust.isEmpty());

	}

}
