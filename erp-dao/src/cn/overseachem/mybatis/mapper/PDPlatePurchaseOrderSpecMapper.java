package cn.overseachem.mybatis.mapper;

import cn.overseachem.mybatis.pojo.PDPlateProductOrderSpec;
import cn.overseachem.mybatis.pojo.PDPlatePurchaseOrderSpec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by freakyuito on 2018/5/22.
 */
public interface PDPlatePurchaseOrderSpecMapper {

    public void insertSpec(String orderNumber,PDPlatePurchaseOrderSpec spec);

    public List<PDPlatePurchaseOrderSpec> findSpecsByOrderNumber(String orderNumber);

    public Integer countSpecsInMonth(@Param("monthBegin") String monthBegin, @Param("monthEnd") String monthEnd);
}
