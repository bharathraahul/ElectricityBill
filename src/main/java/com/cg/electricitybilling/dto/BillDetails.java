package com.cg.electricitybilling.dto;

import java.time.LocalDate;
import java.time.Month;

public class BillDetails {
	
	private Integer bill_id;
	private Integer cust_id;
	private Integer consumer_no;
	private Integer consumed_units;
	private Integer bill_month;
	private LocalDate bill_date;
	private Double amount;
	private LocalDate due_date;
	private Integer meter_id;
	
	
	public BillDetails() {
		
	}
	public BillDetails(Integer bill_id, Integer cust_id, Integer consumer_no, Integer consumed_units, Integer bill_month,
			LocalDate bill_date, Double amount, LocalDate due_date, Integer meter_id) {
		super();
		this.bill_id = bill_id;
		this.cust_id = cust_id;
		this.consumer_no = consumer_no;
		this.consumed_units = consumed_units;
		this.bill_month = bill_month;
		this.bill_date = bill_date;
		this.amount = amount;
		this.due_date = due_date;
		this.meter_id = meter_id;
	}
	@Override
	public String toString() {
		return "BillDetails [bill_id=" + bill_id + ", cust_id=" + cust_id + ", consumer_no=" + consumer_no
				+ ", consumed_units=" + consumed_units + ", bill_month=" + bill_month + ", bill_date=" + bill_date
				+ ", amount=" + amount + ", due_date=" + due_date + ", meter_id=" + meter_id + "]";
	}
	public Integer getBill_id() {
		return bill_id;
	}
	public void setBill_id(Integer bill_id) {
		this.bill_id = bill_id;
	}
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public Integer getConsumer_no() {
		return consumer_no;
	}
	public void setConsumer_no(Integer consumer_no) {
		this.consumer_no = consumer_no;
	}
	public Integer getConsumed_units() {
		return consumed_units;
	}
	public void setConsumed_units(Integer consumed_units) {
		this.consumed_units = consumed_units;
	}
	public Integer getBill_month() {
		return bill_month;
	}
	public void setBill_month(Integer bill_month) {
		this.bill_month = bill_month;
	}
	public LocalDate getBill_date() {
		return bill_date;
	}
	public void setBill_date(LocalDate bill_date) {
		this.bill_date = bill_date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	public Integer getMeter_id() {
		return meter_id;
	}
	public void setMeter_id(Integer meter_id) {
		this.meter_id = meter_id;
	}
	
	

}
