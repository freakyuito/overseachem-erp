package cn.overseachem.mybatis.junit;

import cn.overseachem.mybatis.mapper.PDPlateProductOrderMapper;
import cn.overseachem.mybatis.mapper.PDPlateProductOrderSpecMapper;
import cn.overseachem.mybatis.mapper.PDPlatePurchaseOrderMapper;
import cn.overseachem.mybatis.mapper.PDPlatePurchaseOrderSpecMapper;
import cn.overseachem.mybatis.pojo.PDPlateProductOrder;
import cn.overseachem.mybatis.pojo.PDPlateProductOrderSpec;
import cn.overseachem.mybatis.pojo.PDPlatePurchaseOrder;
import cn.overseachem.mybatis.pojo.PDPlatePurchaseOrderSpec;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

        generateProductOrder("18-6-11");
        generateProductOrder("18007");
        generateProductOrder("18033");
        generateProductOrder("18045");
        generateProductOrder("18065");
        generateProductOrder("1815");
        generateProductOrder("1819");
        generateProductOrder("18314");
        generateProductOrder("18LKL-0314");
        generateProductOrder("20180129");
        generateProductOrder("2K18E-5001");
        generateProductOrder("887Z003");
        generateProductOrder("92159");
        generateProductOrder("WX-11157");

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

        PDPlatePurchaseOrderMapper purchaseOrderMapper = ac.getBean(PDPlatePurchaseOrderMapper.class);
        PDPlatePurchaseOrderSpecMapper purchaseOrderSpecMapper = ac.getBean(PDPlatePurchaseOrderSpecMapper.class);
        PDPlateProductOrderMapper productOrderMapper = ac.getBean(PDPlateProductOrderMapper.class);
        PDPlateProductOrderSpecMapper productOrderSpecMapper = ac.getBean(PDPlateProductOrderSpecMapper.class);

        PDPlatePurchaseOrder sourceOrder = purchaseOrderMapper.findOrderByNumber(sourceOrderNumber);

        PDPlateProductOrder productOrder = new PDPlateProductOrder();

        Date utilDate = new Date();

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        productOrder.setGenerate_time(sqlDate);
        productOrder.setMaker_name(sourceOrder.getMaker_name());
        productOrder.setFk_purchaseOrder_number(sourceOrderNumber);

        String productOrderNumber = generateProductOrderNumber(utilDate);

        productOrder.setProductOrder_number(productOrderNumber);

        productOrderMapper.insertOrder(productOrder);

        List<PDPlatePurchaseOrderSpec> purchaseOrderSpecs = purchaseOrderSpecMapper.findSpecsByOrderNumber(sourceOrderNumber);
        for (PDPlatePurchaseOrderSpec purchaseOrderSpec : purchaseOrderSpecs
                ) {
            PDPlateProductOrderSpec productOrderSpec = new PDPlateProductOrderSpec();
            productOrderSpec.setBatch_number(generateBatchNumber(utilDate));
            productOrderSpec.setFk_productOrder_number(productOrderNumber);
            productOrderSpec.setQuantityCompleted_amount(0);
            productOrderSpec.setState_code("-1");
            productOrderSpecMapper.insertSpec(productOrderSpec);
        }

    }

    public String generateProductOrderNumber(Date date) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String yearBegin = df.format(date) + "-01-01";
        String yearEnd = df.format(date) + "-12-31";

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        PDPlateProductOrderMapper mapper = ac.getBean(PDPlateProductOrderMapper.class);
        Integer count = mapper.countOrdersInYear(yearBegin, yearEnd) + 1;

        String num = df.format(date).substring(2, 4) + String.format("%04d", count);
        System.out.println(num);
        return num;

    }

    public String generateBatchNumber(Date date) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");

        String monthBegin = df.format(date) + "-01";

        Calendar time = Calendar.getInstance();
        time.clear();
        time.set(Calendar.YEAR, Integer.parseInt(df.format(date).substring(0, 4)));
        time.set(Calendar.MONTH, Integer.parseInt(df.format(date).substring(5, 7)) - 1);
        int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数

        String monthEnd = df.format(date) + "-" + day;

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        PDPlateProductOrderSpecMapper mapper = ac.getBean(PDPlateProductOrderSpecMapper.class);

        Integer count = mapper.countSpecsInMonth(monthBegin, monthEnd) + 1;

        String num = (df.format(date).substring(2,4) + String.format("%04d", count)).replace("-","");

        return num;
    }
}
