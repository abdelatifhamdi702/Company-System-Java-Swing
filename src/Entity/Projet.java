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
public class Projet implements MainData{
    
    private int ProNo;
    private String ProName;
    private String Location;
    private int deptNo;

    public int getProNo() {
        return ProNo;
    }

    public void setProNo(int ProNo) {
        this.ProNo = ProNo;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String ProName) {
        this.ProName = ProName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public void add() {
String insert ="insert into project values("
                +ProNo+",'"+ProName+"','"+Location+"',"+deptNo+")";
        boolean isAdd = db.go.RunNonQuery(insert);
        if(isAdd){
        Message("Project is added");
        }}

    @Override
    public void update() {
        String update ="update project set " + "proName='"+ProName+"',"
        +"location='"+Location+"',"+"deptNo="+deptNo+" where deptNo="+deptNo;
        boolean isUpdate=db.go.RunNonQuery(update);
        if(isUpdate){Message("Project is updated");}    }

    @Override
    public void delete() {
        String delete="delete from project where proNo="+ProNo;
        boolean isdelete=db.go.RunNonQuery(delete);
        if(isdelete){Message("Project is deleted");}    }

    @Override
    public String getAutoNumber() {
     return db.go.getAutoNumber("project", "proNo");
    }

    @Override
    public void getAllRows(JTable table) {
        db.go.fillToJTableWithTableName("project", table);
    }

    @Override
    public void getOneRow(JTable table) {
     String select="select * from project where proNo="+ProNo;
     db.go.fillToJTableWithStatement(select, table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
    db.go.fillToJTableWithStatement(Statement, table);    }

    @Override
    public String getValueByName(String Name) {
      String select ="select proNo from project where proName='"+Name+"'";
      String val =(String) db.go.getTableData(select).Items[0][0];
      return val;    }

    @Override
    public String getNameByValue(String Value) {
String select ="select proName from project where proNo='"
             +Value+"'" ;
      String Name =(String) db.go.getTableData(select).Items[0][0];
      return Name;    }
    
}
