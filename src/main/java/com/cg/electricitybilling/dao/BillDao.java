package com.cg.electricitybilling.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.electricitybilling.entity.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer> {

}
