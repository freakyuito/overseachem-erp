package cn.overseachem.mybatis.mapper;

import cn.overseachem.mybatis.pojo.PDPlateProductOrderSpec;

import java.util.List;

/**
 * Created by freakyuito on 2018/5/22.
 */
public interface PDPlateProductOrderSpecMapper {

    public void insertOrdersSpec(PDPlateProductOrderSpec spec);

//    state_code=0待开始 1正在进行 -1暂停 2已完成
    public List<PDPlateProductOrderSpec> findOrdersByStateCode(Integer stateCode);
}
