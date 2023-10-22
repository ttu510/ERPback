package com.example.projectfinal.vo;


import com.example.projectfinal.model.entity.Item;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MainVO {
    private int previousSales;
    private int expectedSales;
    private List<Item> salesRanking;
}
