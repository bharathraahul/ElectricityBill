package com.cg.electricitybilling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Meter")
public class Meter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer meter_id;
	private Integer meter_no;
	
	public Meter()
	{
		
	}
	public Meter(Integer meter_no) {
		super();
		this.meter_no = meter_no;
	}
	@Override
	public String toString() {
		return "Meter [meter_id=" + meter_id + ", meter_no=" + meter_no + "]";
	}
	public Integer getMeter_id() {
		return meter_id;
	}
	public void setMeter_id(Integer meter_id) {
		this.meter_id = meter_id;
	}
	public Integer getMeter_no() {
		return meter_no;
	}
	public void setMeter_no(Integer meter_no) {
		this.meter_no = meter_no;
	}
	
	
	
	

}
