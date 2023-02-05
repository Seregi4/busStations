package com.levanov.busstations.repository;

import com.levanov.busstations.entity.Direct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DirectRepository extends JpaRepository<Direct,Integer> {

}
