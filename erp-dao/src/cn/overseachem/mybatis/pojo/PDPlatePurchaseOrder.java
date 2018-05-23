package cn.overseachem.mybatis.pojo;

import java.util.Date;

public class PDPlatePurchaseOrder {

    private String purchaseOrder_number;

    private String purchaseCompany_name;
    private Date receive_time;
    private Date deliver_time;
    private int quantity_amount;

    private String supervisor_name;
    private String salesman_name;
    private String producer_name;
    private String maker_name;
    private boolean validity_code;

    public String getPurchaseOrder_number() {
        return purchaseOrder_number;
    }

    public void setPurchaseOrder_number(String purchaseOrder_number) {
        this.purchaseOrder_number = purchaseOrder_number;
    }

    public String getPurchaseCompany_name() {
        return purchaseCompany_name;
    }

    public void setPurchaseCompany_name(String purchaseCompany_name) {
        this.purchaseCompany_name = purchaseCompany_name;
    }

    public Date getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(Date receive_time) {
        this.receive_time = receive_time;
    }

    public Date getDeliver_time() {
        return deliver_time;
    }

    public void setDeliver_time(Date deliver_time) {
        this.deliver_time = deliver_time;
    }

    public int getQuantity_amount() {
        return quantity_amount;
    }

    public void setQuantity_amount(int quantity_amount) {
        this.quantity_amount = quantity_amount;
    }

    public String getSupervisor_name() {
        return supervisor_name;
    }

    public void setSupervisor_name(String supervisor_name) {
        this.supervisor_name = supervisor_name;
    }

    public String getSalesman_name() {
        return salesman_name;
    }

    public void setSalesman_name(String salesman_name) {
        this.salesman_name = salesman_name;
    }

    public String getProducer_name() {
        return producer_name;
    }

    public void setProducer_name(String producer_name) {
        this.producer_name = producer_name;
    }

    public String getMaker_name() {
        return maker_name;
    }

    public void setMaker_name(String maker_name) {
        this.maker_name = maker_name;
    }

    public boolean isValidity_code() {
        return validity_code;
    }

    public void setValidity_code(boolean validity_code) {
        this.validity_code = validity_code;
    }

    public String getOperationRecords_id() {
        return operationRecords_id;
    }

    public void setOperationRecords_id(String operationRecords_id) {
        this.operationRecords_id = operationRecords_id;
    }

    private String operationRecords_id;



}