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
public class Employe_Numéros implements MainData{
    private int empNo ;
    private String phone;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void add() {
     String insert = "insert into emp_phones values("+
             empNo+",'"+phone+"')";
     boolean isAdd = db.go.RunNonQuery(insert);
     if(isAdd){
        Message("Phone is added");
    }}

    @Override
    public void update() {
     Message("update don't work in phones");
    }

    @Override
    public void delete() {
     String delete = "delete from emp_phones where empNo"+empNo+" and num'"+phone+"'";
     boolean isDelete = db.go.RunNonQuery(delete);
     if(isDelete){
        Message("Phone is added");}
    }
    
    public void deleteAllPhonesByEmp (){
    String delete = "delete from emp_phones where empNo"+empNo;
    boolean isDelete = db.go.RunNonQuery(delete);
     if(isDelete){
        Message("Phones are added");}
    }
    public String getEmpByPhone(String Yourphone){
    String select ="select empNo from emp_phones where num='"+Yourphone+"'";
    String empNoRet =(String) db.go.getTableData(select).Items[0][0];
    if(db.go.getTableData(select).Items.length<1){
    return "0";
    }
    else{
    return empNoRet;}
    }

    @Override
    public String getAutoNumber() {
    Message("getAutoNumber don't work in phones"); return"";
    }

    @Override
    public void getAllRows(JTable table) {
        String select= "select num from emp_phones where empNo="+empNo;
        db.go.fillToJTableWithStatement(select, table);
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValueByName(String Name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByValue(String Value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
