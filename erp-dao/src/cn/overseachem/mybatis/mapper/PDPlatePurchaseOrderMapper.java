package cn.overseachem.mybatis.mapper;

import cn.overseachem.mybatis.pojo.PDPlatePurchaseOrder;

import java.util.List;

/**
 * Created by freakyuito on 2018/5/21.
 */
public interface PDPlatePurchaseOrderMapper {

    public PDPlatePurchaseOrder findOrderByNumber(String number);

    public List<PDPlatePurchaseOrder> findOrdersByValidityCode(boolean validity);

    public List<PDPlatePurchaseOrder> findOrdersByAllConditions(String number, String companyName, String receiveTimeStart, String receiveTimeEnd, String deliverTimeStart, String deliverTimeEnd);

    public void updateMakerName(String makerName, String orderNumber);

    public void updateProducerName(String makerName, String orderNumber);

    public void updateSalesmanName(String makerName, String orderNumber);

    public void updateSupervisorName(String makerName, String orderNumber);

    public void insertOrder(PDPlatePurchaseOrder order);

    public List<PDPlatePurchaseOrder> findOrdersUnchecked();

    public List<PDPlatePurchaseOrder> findOrdersUnstarted();

    public List<PDPlatePurchaseOrder> findOrdersProcessing();

    public List<PDPlatePurchaseOrder> findOrdersCompleted();

    public List<PDPlatePurchaseOrder> findOrdersDelivered();

}
