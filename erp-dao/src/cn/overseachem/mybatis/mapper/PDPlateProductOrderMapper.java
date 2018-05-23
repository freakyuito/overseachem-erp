package cn.overseachem.mybatis.mapper;

import cn.overseachem.mybatis.pojo.PDPlateProductOrder;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Zhihui_Shen on 2018/5/23.
 */
public interface PDPlateProductOrderMapper {

    public void insertOrder(PDPlateProductOrder order);

    public Integer getOrdersAmountInOneYear(@Param("yearBegin") String yearBegin,@Param("yearEnd") String yearEnd);
}
