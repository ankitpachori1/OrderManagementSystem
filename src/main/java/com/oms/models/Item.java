package com.oms.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Item {

    @JsonProperty("itemId")
    String itemId;

    @JsonProperty("quantity")
    Integer quantity;
}
