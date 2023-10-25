package com.example.projectfinal.service;

import com.example.projectfinal.model.entity.Item;
import com.example.projectfinal.model.entity.Orders;
import com.example.projectfinal.model.entity.Purchase;
import com.example.projectfinal.repository.*;
import com.example.projectfinal.vo.MainVO;
import com.example.projectfinal.vo.OderVOList;
import com.example.projectfinal.vo.OrderVO;
import com.example.projectfinal.vo.Sale_RateVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import java.util.stream.Collectors;

@Service
public class WebService {
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;
    private PurchaseRepository purchaseRepository;

    public WebService(
                      OrderRepository orderRepository,
                      ItemRepository itemRepository,PurchaseRepository purchaseRepository){
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.purchaseRepository = purchaseRepository;
    }


    public MainVO Main(){
        MainVO mainVO = MainVO.builder()
                .expectedSales(orderRepository.getExpectedSales())
                .previousSales(purchaseRepository.getPreviousSales())
                .salesRanking(purchaseRepository.findTop10ByOrderByViewCountDesc(PageRequest.of(0, 5)))
                .build();



        return mainVO;
    }
    public Page<Purchase> Purchase(Pageable pageable){
        Page<Purchase> result = purchaseRepository.findAll(pageable);


        return result;
    }

    public Page<Orders> Orders(Pageable pageable){
        Page<Orders> result = orderRepository.findAll(pageable);


        return result;
    }

    public Page<Item> Items(Pageable pageable){
        Page<Item> items = itemRepository.findAll(pageable);

        return items;
    }

    public Item Item(int id){
        Item item = itemRepository.findById(id).get();

        return item;
    }
}
