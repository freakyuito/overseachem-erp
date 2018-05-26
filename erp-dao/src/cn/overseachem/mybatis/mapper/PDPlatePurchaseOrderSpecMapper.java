package cn.overseachem.mybatis.mapper;

import cn.overseachem.mybatis.pojo.PDPlateProductOrderSpec;
import cn.overseachem.mybatis.pojo.PDPlatePurchaseOrderSpec;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by freakyuito on 2018/5/22.
 */
public interface PDPlatePurchaseOrderSpecMapper {

    public void insertSpec(PDPlatePurchaseOrderSpec spec);

    public List<PDPlatePurchaseOrderSpec> findSpecsByOrderNumber(String orderNumber);

    public Integer countSpecsInMonth(@Param("monthBegin") String monthBegin, @Param("monthEnd") String monthEnd);

    public List<PDPlatePurchaseOrderSpec> groupSpecsByColorIdWithSameOrderNumber(String orderNumber);

    public List<PDPlatePurchaseOrderSpec> findSpecsByOrderNumberAndColorId(@Param("orderNumber") String orderNumber,@Param("colorId") String colorId);



}
