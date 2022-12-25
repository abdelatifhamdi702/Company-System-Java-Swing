/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static Tools.Tools.Message;
import javax.swing.JTable;

/**
 *
 * @author Abdelatif Hamdi
 */
public class WorkOn implements MainData{
    private int empNo;
    private int proNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getProNo() {
        return proNo;
    }

    public void setProNo(int proNo) {
        this.proNo = proNo;
    }

    @Override
    public void add() {
          String insert="insert into work_on values("  +empNo+","+proNo+")";
          boolean isAdd = db.go.RunNonQuery(insert);
        if(isAdd){
        Message("Work_On is added");}
    }

    @Override
    public void update() {
Message("Update don't working in Work_On");    }

    @Override
    public void delete() {
String delete="delete from work_on where proNo="+proNo+" and empNo="+empNo;
        boolean isdelete=db.go.RunNonQuery(delete);
        if(isdelete){Message("WorkOn is deleted");}       }

    @Override
    public String getAutoNumber() {
      Message("getAutoNumber don't working in Work_On"); return "";
    }

    @Override
    public void getAllRows(JTable table) {
     db.go.fillToJTableWithTableName("work_on", table);
    }

    @Override
    public void getOneRow(JTable table) {
    String select = "select * from work_on where proNo="+proNo+" and empNo="+empNo;
    db.go.fillToJTableWithStatement(select, table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
     db.go.fillToJTableWithStatement(Statement, table);
    }

    @Override
    public String getValueByName(String Name) {
Message("getValueByName don't working in Work_On"); return "";    }

    @Override
    public String getNameByValue(String Value) {
Message("getNameByValue don't working in Work_On"); return "";    }
    
    
    
}
