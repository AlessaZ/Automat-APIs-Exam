package com.everis.base.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonPropertyOrder({"id", "petId", "quantity", "shipDate", "status", "complete"})
public class Order {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public Order() {

    }

    public Order(int id, int petId, int quantity) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
    }


}
