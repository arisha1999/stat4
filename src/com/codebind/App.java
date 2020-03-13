package com.codebind;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

public class App extends JFrame {

    private JButton chooseFile;
    private JLabel filePath;
    private JPanel MainForm;
    private JTabbedPane tabbedPane1;
    private JButton Cancel;
    private JButton Next;
    private JComboBox korell1;
    private JComboBox korell2;
    private JTabbedPane tabbedPane2;
    private JLabel picture;
    public String FilePath;
    private Double [][] matrix;
    public App() {
        chooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Выбор файла");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Файлы Excel", "xlsx");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(App.this);
                if (result == JFileChooser.APPROVE_OPTION ) filePath.setText(fileChooser.getSelectedFile().toString());
                FilePath = filePath.getText();
            }
        });
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filePath.setText("");
                korell1.setSelectedIndex(-1);
                korell2.setSelectedIndex(-1);
            }
        });
        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(korell1.getSelectedIndex()==-1||korell2.getSelectedIndex()==-1||filePath.getText()==""){
                    JOptionPane.showMessageDialog(MainForm,"Вставьте все значение");
                }
                else{
                    tabbedPane1.setSelectedIndex(1);
                }
            }
        });
    }
    public void Read() throws IOException {
        XSSFWorkbook inputFile = new XSSFWorkbook(new FileInputStream(FilePath));
        XSSFSheet inputFileSheet = inputFile.getSheet("2005-2018");
        matrix = new Double[13][77];
        for(int i = 0; i < 13;i++){
            for(int j = 0; j < 77; j++){

            }
        }
    }
    public static void main(String []args){
        JFrame frame = new JFrame("App");
        frame.setSize(700,700);
        frame.setContentPane(new App().MainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
