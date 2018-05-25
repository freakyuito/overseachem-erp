package cn.overseachem.mybatis.mapper;

import cn.overseachem.mybatis.pojo.PDPlatePurchaseOrder;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by freakyuito on 2018/5/21.
 */
public interface PDPlatePurchaseOrderMapper {

    public PDPlatePurchaseOrder findOrderByNumber(String number);

    public List<PDPlatePurchaseOrder> findOrdersByValidityCode(boolean validity);

    public List<PDPlatePurchaseOrder> findOrdersByAllConditions(@Param("orderNumber") String number,
                                                                @Param("companyName") String companyName,
                                                                @Param("receiveTimeStart") String receiveTimeStart,
                                                                @Param("receiveTimeEnd") String receiveTimeEnd,
                                                                @Param("deliverTimeStart") String deliverTimeStart,
                                                                @Param("deliverTimeEnd") String deliverTimeEnd);

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

    public HashMap<String,Object> getProductProcessByNumber(String orderNumber);

}
