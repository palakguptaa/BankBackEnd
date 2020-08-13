package com.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.model.Requests;

@Repository
public interface RequestsDAO extends JpaRepository<Requests, Integer> {

}
