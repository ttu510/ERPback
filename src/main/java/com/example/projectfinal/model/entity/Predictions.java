package com.example.projectfinal.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "predictions", schema = "predictions_schema")
public class Predictions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int shop_id;
    @ManyToOne
    private Item item;
    private int real_item_cnt;
    private int predicted_item_cnt;

    @Temporal(TemporalType.DATE)
    private Date createdate;
}
