package com.cg.electricitybilling.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.electricitybilling.entity.User;


@Repository
public interface UserDao extends JpaRepository<User,Integer> {

}
