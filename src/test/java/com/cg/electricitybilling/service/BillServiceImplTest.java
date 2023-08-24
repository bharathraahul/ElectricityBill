package com.cg.electricitybilling.service;

 

import static org.junit.jupiter.api.Assertions.*;

 

import java.time.LocalDate;
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

 

import com.cg.electricitybilling.entity.Bill;

 

 

import jakarta.persistence.EntityManager;

 

 

    @DataJpaTest
    @Import(BillServiceImpl.class)
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    class BillServiceImplTest {
        @Autowired
        private BillService billService;
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
            Bill bill= new Bill(1234, 4567,78,7,LocalDate.of(2023, 4, 5),4567.00,LocalDate.of(2023,4,20),789);
            eManager.persist(bill);
            Bill b=billService.add(bill);
            assertEquals(bill.getBill_id(), b.getBill_id());
        }

 

        @Test
        void testFindAll() {
            List<Bill> bill= billService.findAll();
            assertTrue(!bill.isEmpty());
        }

 

    }