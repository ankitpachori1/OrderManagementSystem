package com.oms.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    @JsonProperty("items")
    List<Item> items;
}
