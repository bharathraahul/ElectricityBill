package com.cg.electricitybilling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.electricitybilling.dao.BillDao;
import com.cg.electricitybilling.entity.Bill;
import com.cg.electricitybilling.exception.UserNotFoundException;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class BillServiceImpl implements BillService {
double rate=3.67;
	@Autowired
	private BillDao bDao;
	
	@Override
	public List<Bill> findAll() {
		List<Bill> bills = bDao.findAll();
		return bills;
	}

	@Override
	public Bill findbyId(Integer bill_id) {
		Optional<Bill> bill= bDao.findById(bill_id);
		Bill bill1=bill.get();
		return bill1;
	}

	@Override
	public String deleteBill(Integer bill_id) {
		Optional <Bill> opt=bDao.findById(bill_id);
		if(!opt.isPresent())
		{
			throw new UserNotFoundException("Invalid bill id");
		}
		Bill bill=opt.get();
		bDao.deleteById(bill_id);
		return ("Deleted Customer with id"+bill_id);	}

	@Override
	public Double calc(Integer consumed_units) {
		double total=consumed_units*rate;
		return total;
	}

	@Override
	public String paymentConfirm(Integer cust_id, String ans,Integer bill_id) {
		Optional<Bill> opt = bDao.findById(bill_id);

		if(!opt.isPresent())

		throw new UserNotFoundException("ivalid bill id"+bill_id);

		 

		if(ans.equalsIgnoreCase("yes")) {

		Bill bDetails = opt.get();

		// mDetails.setSeats_available(mDetails.getSeats_available()-t);

		// System.out.println(mDetails.getSeats_available());

		//System.out.println();

		return "Payment Done";

		}

		else if(ans.equalsIgnoreCase("no")) {

		return "Please try again";

		}

		else

		return "Please confirm yes if payment done, no if not paid";

		
	}

	@Override
	public Bill add(Bill bill) {
    Bill bill1=bDao.save(bill);
		return bill1;
	}

}
