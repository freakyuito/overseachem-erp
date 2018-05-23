package cn.overseachem.mybatis.pojo;

import java.sql.Date;

/**
 * Created by Zhihui_Shen on 2018/5/23.
 */
public class PDPlateProductOrder {
    private Integer machine_number;
    private Date generate_time;
    private String maker_name;
    private String approver_name;
    private String receiver_name;
    private String fk_purchaseOrder_number;
    private String fk_operationRecords_id;
    private String productOrder_number;
    private String productCompany_name;

    public String getApprover_name() {
        return approver_name;
    }

    public void setApprover_name(String approver_name) {
        this.approver_name = approver_name;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getFk_operationRecords_id() {
        return fk_operationRecords_id;
    }

    public void setFk_operationRecords_id(String fk_operationRecords_id) {
        this.fk_operationRecords_id = fk_operationRecords_id;
    }

    public String getProductOrder_number() {
        return productOrder_number;
    }

    public void setProductOrder_number(String productOrder_number) {
        this.productOrder_number = productOrder_number;
    }

    public Integer getMachine_number() {
        return machine_number;
    }

    public void setMachine_number(Integer machine_number) {
        this.machine_number = machine_number;
    }

    public Date getGenerate_time() {
        return generate_time;
    }

    public void setGenerate_time(Date generate_time) {
        this.generate_time = generate_time;
    }

    public String getMaker_name() {
        return maker_name;
    }

    public void setMaker_name(String maker_name) {
        this.maker_name = maker_name;
    }

    public String getFk_purchaseOrder_number() {
        return fk_purchaseOrder_number;
    }

    public void setFk_purchaseOrder_number(String fk_purchaseOrder_number) {
        this.fk_purchaseOrder_number = fk_purchaseOrder_number;
    }

    public String getProductCompany_name() {
        return productCompany_name;
    }

    public void setProductCompany_name(String productCompany_name) {
        this.productCompany_name = productCompany_name;
    }

}
