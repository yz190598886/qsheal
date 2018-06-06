package Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author arryluo
 *
 */
public class OneExcelDemo {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    private static XSSFWorkbook xssfWorkbook = null;
    private static HSSFWorkbook workbook = null;


    public List<Params> read(String Path) {
        // 判断后缀是xls，还是xlsx
        File file = new File(Path);
        if (checkFile(file)) {
            // 进行后缀为xlsx的Excel操作
            xlsx(file);
        } else {
            // 进行xls的操作
            xls(file);
        }

        return xlsx(file);
    }

    // 检查该文件是否是xls，还是xlsx类型
    private static boolean checkFile(File file) {
        boolean flg = false;
        if (file.exists()) {

            String name = file.getName();
            // String lastindex = name.substring(name.lastIndexOf(".") + 1);
            if (name.endsWith(EXCEL_XLSX))
                flg = true;
            else
                flg = false;
        } else {
            System.out.println("文件不存在");
        }
        return flg;
    }

    // 如果是xlsx，做什么操作
    private static List<Params> xlsx(File file) {

        try {
            xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
            show(xssfWorkbook);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return show(xssfWorkbook);
    }

    //他们两者都有相同的父类，而且都是父类中的方法操作，那我干脆点直接将他们用父类的形式抽取出来，这样解决了代码的冗余问题
    private static List<Params> show(Workbook workbook) {
        List<Params> list=new ArrayList<>();
        String [] b = new String[3];
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            Sheet xssfSheet = workbook.getSheetAt(numSheet);
            // 这种主要是判断是否含空以免包空指针
            if (xssfSheet == null) {
                continue;
            }

            // 循环行Row
            // 从第2行读取
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                Row xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
                // 循环列Cell
//                System.out.println("多少列" + xssfRow.getLastCellNum());
                for (int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++) {
                    Cell xssfCell = xssfRow.getCell(cellNum);
                    if (xssfCell == null) {
                        continue;
                    }
//                    System.out.println(getValue(xssfCell, workbook));
                    String a=getValue(xssfCell, workbook);
                    b[cellNum]=a;
                }
//                System.out.println(b);
                Params params=new Params();
                params.setUrl(b[0]);
                params.setParameter(b[1]);
                params.setResult(b[2]);
                list.add(params);
//                System.out.println(list);
            }
//            System.out.println(list.get(0).getUrl());
//            System.out.println(list.get(1).getParameter());
//            System.out.println(list.get(2).getResult());
        }
        return list;
    }

    // 如果是就做什么操作
    private static void xls(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            workbook = new HSSFWorkbook(inputStream);
            show(workbook);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("static-access")
    // 将他们两者的父类抽取出来，这样减少代码量，同时便于管理
    private static String getValue(Cell xssfCell, Workbook workbook) {
        String value = "";
        switch (xssfCell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = String.valueOf(xssfCell.getRichStringCellValue()
                        .getString());
//                System.out.print("|");
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(xssfCell)) {
                    value = String.valueOf(String.valueOf(xssfCell
                            .getDateCellValue()));
                } else {
                    value = String.valueOf(xssfCell.getNumericCellValue());
                }
//                System.out.print("|");
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = String.valueOf(xssfCell.getBooleanCellValue());
//                System.out.print("|");
                break;
            // 公式,
            case Cell.CELL_TYPE_FORMULA:
                // 获取Excel中用公式获取到的值,//=SUM(P4-Q4-R4-S4)Excel用这种类似的公式计算出来的值用POI无法获取，要想获取的话，就必须一下操作
                FormulaEvaluator evaluator = workbook.getCreationHelper()
                        .createFormulaEvaluator();
                evaluator.evaluateFormulaCell(xssfCell);
                CellValue cellValue = evaluator.evaluate(xssfCell);
                value = String.valueOf(cellValue.getNumberValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                value = String.valueOf(xssfCell.getErrorCellValue());
                break;
            default:
        }
        return value;
    }
}

