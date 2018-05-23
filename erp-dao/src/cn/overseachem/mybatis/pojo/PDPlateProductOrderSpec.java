package cn.overseachem.mybatis.pojo;

/**
 * Created by freakyuito on 2018/5/22.
 */
public class PDPlateProductOrderSpec {

    private String state_code;
    private String batch_number;
    private String fk_productOrder_number;
    private int quantityCompleted_amount;

    public String getFk_productOrder_number() {
        return fk_productOrder_number;
    }

    public void setFk_productOrder_number(String fk_productOrder_number) {
        this.fk_productOrder_number = fk_productOrder_number;
    }


    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public int getQuantityCompleted_amount() {
        return quantityCompleted_amount;
    }

    public void setQuantityCompleted_amount(int quantityCompleted_amount) {
        this.quantityCompleted_amount = quantityCompleted_amount;
    }


}
