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
public class Employe implements MainData{
    private int empNo;
    private String empName;
    private String address;
    private double Salaire;
    private String HDate;
    private String BDate;
    private int deptNo ;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalaire() {
        return Salaire;
    }

    public void setSalaire(double Salaire) {
        this.Salaire = Salaire;
    }

    public String getHDate() {
        return HDate;
    }

    public void setHDate(String HDate) {
        this.HDate = HDate;
    }

    public String getBDate() {
        return BDate;
    }

    public void setBDate(String BDate) {
        this.BDate = BDate;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public void add() {
        String insert ="insert into emp values("
                +empNo+",'"+empName+"','"+address+"',"+Salaire+","+"'"+HDate+"',"
                +"'"+BDate+"',"+deptNo+ ")";
        boolean isAdd = db.go.RunNonQuery(insert);
        if(isAdd){
        Message("Employe is added");
    }}
    

    @Override
    public void update() {
       String update ="update emp set " + "empName='"+empName+"',"
        +"address='"+address+"',"+"salaire="+Salaire+", hDate='"+HDate+
        "',bDate='"+BDate+"',deptNo="+deptNo+" where empNo="+empNo;
        boolean isUpdate=db.go.RunNonQuery(update);
        if(isUpdate){Message("Employe is updated");}
     
    }
    

    @Override
    public void delete() {
       String delete="delete from emp where empNo="+empNo;
        boolean isdelete=db.go.RunNonQuery(delete);
        if(isdelete){Message("Employe is deleted");}}

    @Override
    public String getAutoNumber() {
        String auto = db.go.getAutoNumber("emp", "empNo");
        return auto;    }

    @Override
    public void getAllRows(JTable table) {
     db.go.fillToJTableWithTableName("emp", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String select="select * from emp where empNo="+empNo;
       db.go.fillToJTableWithStatement(select, table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTableWithStatement(Statement, table);
    }

    @Override
    public String getValueByName(String Name) {
     String select ="select empNo from emp where empName='"
             +Name+"'" ;
      String val =(String) db.go.getTableData(select).Items[0][0];
      return val;    }

    @Override
    public String getNameByValue(String Value) {
String select ="select empName from emp where empNo='"
             +Value+"'" ;
      String Name =(String) db.go.getTableData(select).Items[0][0];
      return Name;    }
    
}
