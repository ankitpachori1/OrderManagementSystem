package com.oms.models;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    List<Item> items;

    Status status;
}
