package com.cg.electricitybilling.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.electricitybilling.dto.BillDetails;
import com.cg.electricitybilling.entity.Bill;

@Component
public class BillUtil {

	public List<BillDetails> toDetails(List<Bill> bills) {
		List<BillDetails> details = new ArrayList<>();
		for (Bill bill : bills) {
			BillDetails c = toDetails(bill);
			details.add(c);
		}		
		return details;	}

	public BillDetails toDetails(Bill bill) {
		BillDetails details=null;
		details=new BillDetails(bill.getBill_id(),bill.getCust_id(),bill.getConsumer_no(),bill.getConsumed_units(),bill.getBill_month(),bill.getBill_date(),bill.getAmount(),bill.getDue_date(),bill.getMeter_id());
		return details;
	}

}
