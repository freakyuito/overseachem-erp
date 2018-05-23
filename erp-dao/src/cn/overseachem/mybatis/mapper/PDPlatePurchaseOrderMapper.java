package cn.overseachem.mybatis.mapper;

import cn.overseachem.mybatis.pojo.PDPlatePurchaseOrder;

import java.util.List;

/**
 * Created by freakyuito on 2018/5/21.
 */
public interface PDPlatePurchaseOrderMapper {

    public List<PDPlatePurchaseOrder> findOrdersByValidityCode(boolean validity);

    public List<PDPlatePurchaseOrder> findOrdersByAllConditions(String number,String companyName,String receiveTimeStart,String receiveTimeEnd,String deliverTimeStart,String deliverTimeEnd);

    public List<PDPlatePurchaseOrder> findUncheckedOrders();

}
