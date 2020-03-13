package com.codebind;

import com.sun.tools.javac.util.Convert;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Regression {
    private Integer x[][] = new Integer[1078][17];
    private Integer y[] = new Integer[1078];
    private Double r;
    private String filename;
    public Regression(String filename) throws IOException {
        Read_from_file();
        this.filename = filename;
    }
    public void Read_from_file() throws IOException {
        //файл для чтения информации
        XSSFWorkbook inputFile = new XSSFWorkbook(new FileInputStream(filename));
        XSSFSheet inputFileSheet = inputFile.getSheet("2005-2018");
        for(int i = 0 ;i < 1078;i++){
            for(int j = 0; j < 17; j++){
                x[i][j] = (int)inputFileSheet.getRow(j+1).getCell(i+2).getNumericCellValue();
                System.out.print(x[i][j]+" ");
            }
            System.out.println("");
        }
        for(int i = 0; i < 1078;i++){
            y[i] = (int)inputFileSheet.getRow(i+1).getCell(19).getNumericCellValue();
        }
    }
}
