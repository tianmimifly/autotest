package com.milan.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.milan.entity.ExcelCaseConfig;
import com.milan.entity.ExcelCaseOne;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
    private Workbook xssfWorkbook = null;
    //case表
    private Sheet xssfSheet_Case = null;
    //初始化表
    private Sheet xssfSheet_Init =null;
    private Row firstRow = null; // /取出第一行 作为字段
    private int caseAssertCellIndex = 0; // 保存caseAssert这一列的索引
    private int returnDataCellIndex = 0;// 保存returnData这一列的索引
    private int endSqlExcuteCellIndex=0; //保存desc的sql执行
    private int initSqlExcuteCellIndex=0;//保存预置条件sql执行结果
    private String _filePath = "";
    private ExcelCaseConfig exCaseInit =null;

    public ExcelHelper(String filePath) {
        try {
            _filePath = filePath;
            xssfWorkbook = new XSSFWorkbook(new FileInputStream(filePath));
            xssfSheet_Case = xssfWorkbook.getSheetAt(0);
            xssfSheet_Init=xssfWorkbook.getSheetAt(1);
            SetCaseInit();
            firstRow = xssfSheet_Case.getRow(0);
            for (int i = 0; i < firstRow.getLastCellNum(); i++) {
                String fieldValue = getValue(firstRow.getCell(i));
                if (fieldValue.indexOf("caseAssert") > -1) {
                    caseAssertCellIndex = i;
                }
                if (fieldValue.indexOf("returnData") > -1) {
                    returnDataCellIndex = i;
                }
                if (fieldValue.indexOf("end_sql_excute") > -1) {
                    endSqlExcuteCellIndex = i;
                }
                if (fieldValue.indexOf("init_sql_excute") > -1) {
                    initSqlExcuteCellIndex = i;
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Map<String, String>> readXlsx() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (int rowNum = 1; rowNum <= xssfSheet_Case.getLastRowNum(); rowNum++) {
            Row xssfRow = xssfSheet_Case.getRow(rowNum);
            if (xssfRow == null) {
                continue;
            }
            Map<String, String> map = new HashMap<String, String>();
            // 循环列Cell
            for (int cellNum = 0; cellNum < firstRow.getLastCellNum(); cellNum++) {
                Cell dataCell = xssfRow.getCell(cellNum);
                Cell fieldCell = firstRow.getCell(cellNum);
                map.put(getValue(fieldCell), getValue(dataCell));
                map.put("${d}rowIndex", String.valueOf(rowNum));
            }
            list.add(map);
        }
        return list;
    }

    @SuppressWarnings("static-access")
    private String getValue(Cell xssfCell) {
        if (xssfCell == null) {
            return "";
        }
        if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfCell.getNumericCellValue());
        } else {
            return String.valueOf(xssfCell.getStringCellValue());
        }
    }

    // /更新执行结果


    public void updateExcuteResult(ExcelCaseOne c) {
        Row row = xssfSheet_Case.getRow(Integer.parseInt(c.getExcelCaseDesc().getRowIndex()) );

        row.getCell(caseAssertCellIndex).setCellValue(c.getExcelCaseEnd().getCaseAssert());
        row.getCell(returnDataCellIndex).setCellValue(c.getExcelCaseEnd().getReturnData());
        row.getCell(endSqlExcuteCellIndex).setCellValue(c.getExcelCaseEnd().getEnd_sql_excute());
        row.getCell(initSqlExcuteCellIndex).setCellValue(c.getExcelCasePreset().getInit_sql_excute());
        CellStyle cs = xssfWorkbook.createCellStyle();
        //断言失败，高亮显示
        if (c.getExcelCaseEnd().getCaseAssert().equals("F")){
            cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            cs.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        }
        row.getCell(caseAssertCellIndex).setCellStyle(cs);
        //cs.setFillPattern(HSSFCellStyle.NO_FILL);
        //cs.setFillForegroundColor((short)0);
        //cs = xssfWorkbook.createCellStyle();
       // cs.setVerticalAlignment(CellStyle.VERTICAL_TOP);
    }
    // /写入文件
    public void writeExcelResult() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(_filePath);

            xssfWorkbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ExcelCaseConfig getExCaseInit() {
        return exCaseInit;
    }
    private void  SetCaseInit(){
        if (xssfSheet_Init !=null &&xssfSheet_Init.getLastRowNum()>=1 ){
            exCaseInit = new ExcelCaseConfig();
            //读取第一行的数据写入到caseInit
            exCaseInit.setUrl(getValue(xssfSheet_Init.getRow(1).getCell(0)));
            exCaseInit.setMethod(getValue(xssfSheet_Init.getRow(1).getCell(1)));
            exCaseInit.setRequest_header(getValue(xssfSheet_Init.getRow(1).getCell(2)));
            exCaseInit.setInit_sql(getValue(xssfSheet_Init.getRow(1).getCell(3)));
            exCaseInit.setEnd_sql(getValue(xssfSheet_Init.getRow(1).getCell(4)));
        }
    }

}
