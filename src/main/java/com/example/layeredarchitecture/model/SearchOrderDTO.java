package com.example.layeredarchitecture.model;

public class SearchOrderDTO {
    private String orderId;
    private String date;
    private String code;
    private String description;
    private String qtyOnHand;
    private String unitPrice;


    public SearchOrderDTO() {
    }

    public SearchOrderDTO(String orderId, String date, String code, String description, String qtyOnHand, String unitPrice) {
        this.orderId = orderId;
        this.date = date;
        this.code = code;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(String qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "SearchOrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", date='" + date + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", qtyOnHand='" + qtyOnHand + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}
