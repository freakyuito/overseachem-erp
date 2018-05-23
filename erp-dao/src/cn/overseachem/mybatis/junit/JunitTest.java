package cn.overseachem.mybatis.junit;

import cn.overseachem.mybatis.mapper.PDPlateProductOrderMapper;
import cn.overseachem.mybatis.mapper.PDPlatePurchaseOrderMapper;
import cn.overseachem.mybatis.mapper.PDPlatePurchaseOrderSpecMapper;
import cn.overseachem.mybatis.pojo.PDPlateProductOrder;
import cn.overseachem.mybatis.pojo.PDPlatePurchaseOrder;
import cn.overseachem.mybatis.pojo.PDPlatePurchaseOrderSpec;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class JunitTest {


    @Test
    public void testMapper() throws Exception {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PDPlatePurchaseOrderMapper mapper = ac.getBean(PDPlatePurchaseOrderMapper.class);
////        List<PDPlatePurchaseOrder> orders1 = mapper.findOrdersByNumber("18");
////        for (PDPlatePurchaseOrder s : orders1
////                ) {
////            System.out.println(s.getPurchaseCompany_name());
////        }
////        List<PDPlatePurchaseOrder> orders2 = mapper.findOrdersByCompanyName("A");
////        for (PDPlatePurchaseOrder s : orders2
////                ) {
////            System.out.println(s.getPurchaseCompany_name());
////        }
////        List<PDPlatePurchaseOrder> orders3 = mapper.findOrdersByPeriod("2018-5-1 00:00:00","2018-11-1 00:00:00");
////        for (PDPlatePurchaseOrder s : orders3
////                ) {
////            System.out.println(s.getPurchaseCompany_name());
////        }
////        List<PDPlatePurchaseOrder> orders4 = mapper.findOrdersByAllConditions("8", "ALL","2018-5-1","2018-6-1","2018-6-1","2018-6-30");
////        for (PDPlatePurchaseOrder s : orders4
////                ) {
////            System.out.println(s.getPurchaseOrder_number() + s.getPurchaseCompany_name());
////        }
//        List<PDPlatePurchaseOrder> orders4 = mapper.findUncheckedOrders();
//        for (PDPlatePurchaseOrder s : orders4
//                ) {
//            System.out.println(s.getPurchaseOrder_number() + s.getSalesman_name());
//        }
//
        generateProductOrder("18007");
    }

    public void addPurchaseOrder(PDPlatePurchaseOrder order, List<PDPlatePurchaseOrderSpec> specs) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        PDPlatePurchaseOrderMapper mapper = ac.getBean(PDPlatePurchaseOrderMapper.class);
        PDPlatePurchaseOrderSpecMapper mapper2 = ac.getBean(PDPlatePurchaseOrderSpecMapper.class);

        mapper.insertOrder(order);

        for (PDPlatePurchaseOrderSpec s : specs
                ) {
            mapper2.insertSpec(order.getPurchaseOrder_number(), s);
        }
    }

    public void generateProductOrder(String sourceOrderNumber) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        PDPlatePurchaseOrderMapper pdPlatePurchaseOrderMapper = ac.getBean(PDPlatePurchaseOrderMapper.class);
        PDPlateProductOrderMapper pdPlateProductOrderMapper = ac.getBean(PDPlateProductOrderMapper.class);

        PDPlatePurchaseOrder sourceOrder = pdPlatePurchaseOrderMapper.findOrderByNumber(sourceOrderNumber);
        PDPlateProductOrder productOrder = new PDPlateProductOrder();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        productOrder.setGenerate_time(df.format(new Date()).toString());
        productOrder.setMaker_name(sourceOrder.getMaker_name());
        productOrder.setFk_purchaseOrder_number(sourceOrderNumber);
        System.out.println(pdPlateProductOrderMapper.getOrdersAmountInOneYear( "2018-1-1","2018-6-1"));
        productOrder.setProductOrder_number("");
//        pdPlateProductOrderMapper.insertOrder();

    }
}
