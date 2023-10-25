package com.example.projectfinal.repository;

import com.example.projectfinal.model.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    //@Query("select sum(o.Order_Quantity * i.price)from Orders o " +
       //     "left outer join Item i on o.item = i where o.Order_State ='go'")
    @Query("select sum(p.predicted_item_cnt * i.price)  from Predictions p join Item i on p.item=i")    
    int getExpectedSales();

}
