package com.spoms.order.reprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spoms.order.reprint.entity.OrderDetailsDTO;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetailsDTO, Long>{

}
