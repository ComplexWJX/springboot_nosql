package com.asiainfo.util;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XML2JSONUtil {
    public final static String xmlstr = "<?xml version='1.0' encoding='GB2312'?>"
            + "<workflow label='judgeOld' tasktype='process' tasktag='judgeOld$aiop' isusemq='false' owntype='ESB'>"
            + "<vars name='_TASK_JUGE_RESULT' datatype='java.lang.String' inouttype='inner' description='判断节点结果'/>"
            + "<vars name='$sysParams' datatype='java.util.Map' inouttype='in' description='系统参数'/>"
            + "<vars name='$busiParams' datatype='java.util.Map' inouttype='in' description='业务参数'/>"
            + "<vars name='$returnv' datatype='java.util.Map' inouttype='out' description='流程返回值'/>"
            + "<vars name='$bpmContext' datatype='java.util.Map' inouttype='in' description='流程上下文参数'/>"
            + "<task id='1153' label='test' tasktype='ex_autodecision'>"
            + "<uiinfo>486,254,32,32</uiinfo>"
            + "<gotoitem condition='default' goto='512'/>"
            + "<gotoitem condition='true' goto='1088'/>" + "<autodeal>"
            + "<runtype>CENCOM</runtype>" + "<centercode>ORDER</centercode>"
            + "<servicecode>Service_000107</servicecode>"
            + "<servicename>test</servicename>" + "</autodeal>" + "</task>"
            + "<task id='1088' label='CENTER_SER_BZD' tasktype='ex_auto'>"
            + "<uiinfo>656,303,32,32</uiinfo>" + "<gotoitem goto='512'/>"
            + "<autodeal>" + "<runtype>CENCOM</runtype>"
            + "<centercode>ORDER</centercode>"
            + "<servicecode>QueryCustomerInfo</servicecode>"
            + "<servicename>CENTER_SER_BZD</servicename>" + "</autodeal>"
            + "</task>"
            + "<task id='535' label='jxnengkaitest' tasktype='ex_auto'>"
            + "<uiinfo>477,154,32,32</uiinfo>" + "<gotoitem goto='1153'/>"
            + "<autodeal>" + "<runtype>CENCOM</runtype>"
            + "<centercode>ORDER1</centercode>"
            + "<servicecode>Service_000088</servicecode>"
            + "<servicename>jxnengkaitest</servicename>" + "</autodeal>"
            + "</task>" + "<task id='501' label='开始' tasktype='ex_start'>"
            + "<uiinfo>477,48,32,32</uiinfo>" + "<gotoitem goto='535'/>"
            + "<autodeal>" + "<runtype/>" + "<centercode/>" + "<servicecode/>"
            + "<servicename/>" + "</autodeal>" + "</task>"
            + "<task id='512' label='结束' tasktype='ex_finish'>"
            + "<uiinfo>488,397,32,32</uiinfo>" + "<autodeal>" + "<runtype/>"
            + "<centercode/>" + "<servicecode/>" + "<servicename/>"
            + "</autodeal>" + "</task>" + "</workflow>";

    public static void main(String[] args) {
        try {
            convert2Json(xmlstr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String convert2Json(String xmlStr) throws Exception {
        Document doc = DocumentHelper.parseText(xmlStr);
        Element root = doc.getRootElement();
        Iterator<Element> iterator = root.elementIterator("task");
        while (iterator.hasNext()) {
            Element taskEle = iterator.next();
            // 解析出task元素的所有属性 TODO
            // System.out.println(taskEle.attributeValue("tasktype"));
            // 解析出task元素的所有子元素
            Element uiinfoEle = taskEle.element("uiinfo");
            // 解析出autodeal下元素
            Element autodeal = taskEle.element("autodeal");
            Element runtype = autodeal.element("runtype");
            Element servicecode = autodeal.element("servicecode");
            Element centercode = autodeal.element("centercode");
            System.out.println(uiinfoEle.getText());
            // if(){}
            System.out.println(runtype.getText());
            System.out.println(servicecode.getText());
            System.out.println(centercode.getText());
        }
        return "";
    }
}
