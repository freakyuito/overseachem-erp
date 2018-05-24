package cn.overseachem.mybatis.pojo;

/**
 * Created by Zhihui_Shen on 2018/5/23.
 */
public class PDPlatePurchaseOrderSpec {

    private String fk_purchaseOrder_number;
    private String fk_pattern_id;
    private String fk_color_id;
    private String size;
    private Integer total_quantity;
    private String remark;
    private String batch_number;

    public String getFk_purchaseOrder_number() {
        return fk_purchaseOrder_number;
    }

    public void setFk_purchaseOrder_number(String fk_purchaseOrder_number) {
        this.fk_purchaseOrder_number = fk_purchaseOrder_number;
    }

    public String getFk_pattern_id() {
        return fk_pattern_id;
    }

    public void setFk_pattern_id(String fk_pattern_id) {
        this.fk_pattern_id = fk_pattern_id;
    }

    public String getFk_color_id() {
        return fk_color_id;
    }

    public void setFk_color_id(String fk_color_id) {
        this.fk_color_id = fk_color_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(Integer total_quantity) {
        this.total_quantity = total_quantity;
    }

    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }
}
