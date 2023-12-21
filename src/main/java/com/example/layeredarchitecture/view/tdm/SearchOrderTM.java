package com.example.layeredarchitecture.view.tdm;

public class SearchOrderTM {
    private String code;
    private String description;
    private String qtyOnHand;
    private String unitPrice;
    private double total;

    public SearchOrderTM() {
    }

    public SearchOrderTM(String code, String description, String qtyOnHand, String unitPrice, double total) {
        this.code = code;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
        this.total = total;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SearchOrderTM{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", qtyOnHand='" + qtyOnHand + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", total=" + total +
                '}';
    }
}
