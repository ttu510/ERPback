package com.example.projectfinal.repository;

import com.example.projectfinal.model.entity.Item;
import com.example.projectfinal.model.entity.Purchase;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("select sum(p.Purchase_Price)from Purchase p")
    int getPreviousSales();

    @Query("select i from Purchase p left outer join Item i on p.item = i order by p.Purchase_Quantity, p.Purchase_Price desc")
    List<Item> findTop10ByOrderByViewCountDesc(Pageable pageable);
}
