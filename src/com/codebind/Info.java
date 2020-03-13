package com.codebind;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.io.IOException;

public class Info{
    protected JPanel MainMenu;
    private JTabbedPane tabbedPane1;
    public String filename;
    public Info() throws IOException {
//        DefaultTableModel model = new DefaultTableModel(10,2);
//        info.setModel(model);
//        info.getColumn(0).setHeaderValue("Параметр");
//        info.getColumn(1).setHeaderValue("Расшифровка");
        Regression model_ = new Regression(filename);
    }
    public static void main(String []args){

    }
}
