package cn.overseachem.mybatis.mapper;

import cn.overseachem.mybatis.pojo.PDPlateProductOrderSpec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by freakyuito on 2018/5/22.
 */
public interface PDPlateProductOrderSpecMapper {

    public void insertSpec(PDPlateProductOrderSpec spec);

//    state_code=0待开始 1正在进行 -1暂停 2已完成
    public List<PDPlateProductOrderSpec> findOrdersByStateCode(Integer stateCode);

    public Integer countSpecsInMonth(@Param("monthBegin") String monthBegin,@Param("monthEnd") String monthEnd);
}
