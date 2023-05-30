package com.csiit.seatease.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.csiit.seatease.entity.Block;
import com.csiit.seatease.entity.Floor;

public interface BlockRepository extends JpaRepository<Block, Long> {

}

