package com.cg.electricitybilling.service;

import java.util.List;

import com.cg.electricitybilling.entity.Bill;

public interface BillService {

	List<Bill> findAll();

	Bill findbyId(Integer bill_id);

	String deleteBill(Integer bill_id);

	Double calc(Integer consumed_units);

	String paymentConfirm(Integer cust_id, String ans, Integer bill_id);

	Bill add(Bill bill);

}
