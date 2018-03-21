/**
 * @create by tmm
 * */
package com.milan.utils;
import com.milan.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelCaseUtil {
    private List<Map<String,String>> caseExcelList;
    private  List<ExcelCaseOne> excelAllList ;
    private List<ExcelCaseOne> excelExcuteList ;
    private ExcelCaseConfig excelCaseConfig;

    public ExcelCaseConfig getExcelCaseConfig() {
        return excelCaseConfig;
    }
    public void setExcelCaseConfig(ExcelCaseConfig excelCaseConfig) {
        this.excelCaseConfig = excelCaseConfig;
    }

    public Object[][] getExcuteProvider() {
        return excuteProvider;
    }
    private Object[][] excuteProvider;
    public ExcelCaseUtil(List<Map<String,String>> _caseExcelList){
        caseExcelList =_caseExcelList;
        excelAllList = getListAllByExcel(caseExcelList);
        excelExcuteList =getExcuteList(excelAllList);
        excuteProvider =setObjArrByList(excelExcuteList);
    }
    private  ExcelCaseOne getCaseOneByMap(Map<String,String> caseExcelMap) {
        Map<String,String> caseParam = new HashMap<String,String>();
        ExcelCasePreset excelCasePreset=new ExcelCasePreset();
        ExcelCaseDesc excelCaseDesc =new ExcelCaseDesc();
        ExcelCaseEnd excelCaseEnd =new ExcelCaseEnd();
        ExcelCaseOne excelCaseOne = new ExcelCaseOne();
        try {
        for (String key : caseExcelMap.keySet()) {
            if (key.indexOf("${d}")== 0){
                    ClassUtil.setValue(excelCaseDesc,key.replace("${d}", ""),caseExcelMap.get(key));
            }
            else if(key.indexOf("${p}") == 0){
                ClassUtil.setValue(excelCasePreset,key.replace("${p}", ""),caseExcelMap.get(key));
            }
            else if (key.indexOf("${e}")==0){
                ClassUtil.setValue(excelCaseEnd,key.replace("${e}", ""),caseExcelMap.get(key));
            }
            else {
                String strValue = caseExcelMap.get(key);
                if (!strValue.equals("")){
                    caseParam.put(key, strValue);
                }
            }
        }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        excelCaseOne.setCaseParam(caseParam);
        excelCaseOne.setExcelCaseDesc(excelCaseDesc);
        excelCaseOne.setExcelCasePreset(excelCasePreset);
        excelCaseOne.setExcelCaseEnd(excelCaseEnd);
        return  excelCaseOne;
    }
    private  List<ExcelCaseOne> getExcuteList(List<ExcelCaseOne> listAll){
        List<ExcelCaseOne> list2 = new ArrayList<ExcelCaseOne>();
        if (listAll ==null){return  list2;}
        listAll.forEach(p->{
            if(p.getExcelCaseDesc().getIsexcute().equals("y")){
                list2.add(p);
            }
        });
        return  list2;
    }
    private  Object[][] setObjArrByList(List<ExcelCaseOne> excutelist){
        Object[][] objArray = new Object[excutelist.size()][];
        for (int i=0;i<excutelist.size();i++){
            objArray[i] = new Object[]{excutelist.get(i)};
        }
        return  objArray;
    }
    private  List<ExcelCaseOne> getListAllByExcel(List<Map<String,String>> caseExcelList){
        List<ExcelCaseOne> lci = new ArrayList<ExcelCaseOne>();
        if(caseExcelList.size()> 0) {
            caseExcelList.forEach(p -> {
              lci.add(getCaseOneByMap(p));
            });
        }
        return lci;
    }
    //根据ID查找一条数据
    public ExcelCaseOne findCaseOneByID(String strID){
        if(excelAllList !=null && excelAllList.size()> 0){
            for (ExcelCaseOne e : excelAllList){
                if (e.getExcelCaseDesc().getCaseID().equals(strID)){
                    return e;
                }
            }
        }
        return null;
    }
}

