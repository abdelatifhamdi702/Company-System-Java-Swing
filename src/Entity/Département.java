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
public class Département implements MainData{
    private int deptNo;
    private String deptName;
    private String location;

    
    @Override
    public void add() {
        String insert ="insert into dept values("
                +deptNo+",'"+deptName+"','"+location+"')";
        boolean isAdd = db.go.RunNonQuery(insert);
        if(isAdd){
        Message("Departement is added");
        }}

    @Override
    public void update() {
        String update ="update dept set " + "deptName='"+deptName+"',"
        +"location='"+location+"'"+" where deptNo="+deptNo;
        boolean isUpdate=db.go.RunNonQuery(update);
        if(isUpdate){Message("Departement is updated");}
     
    }

    @Override
    public void delete() {
        String delete="delete from dept where deptNo="+deptNo;
        boolean isdelete=db.go.RunNonQuery(delete);
        if(isdelete){Message("Departement is deleted");}

    }

    @Override
    public String getAutoNumber() {
        String auto = db.go.getAutoNumber("dept", "deptNo");
        return auto;

    }

    @Override
    public void getAllRows(JTable table) {
       db.go.fillToJTableWithTableName("dept", table);
    }

    @Override
    public void getOneRow(JTable table) {
       String select="select * from dept where deptNo="+deptNo;
       db.go.fillToJTableWithStatement(select, table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTableWithStatement(Statement, table);

    }

    @Override
    public String getValueByName(String Name) {
      String select ="select deptNo from dept where deptName='"
             +Name+"'" ;
      String val =(String) db.go.getTableData(select).Items[0][0];
      return val;
    }

    @Override
    public String getNameByValue(String Value) {
        String select ="select deptName from dept where deptNo='"
             +Value+"'" ;
      String Name =(String) db.go.getTableData(select).Items[0][0];
      return Name;

    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNO) {
        this.deptNo = deptNO;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
}
