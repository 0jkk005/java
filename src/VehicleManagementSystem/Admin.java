/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleManagementSystem;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Admin {

    /**
     * @param args the command line arguments
     */
    DbConnection conn = new DbConnection();
    ResultSet rst = null;
   public void changePassword(String username,String newPassword)
    {
        int flag;
        
         try{
        conn.OpenConnection();
        String sql = "UPDATE Admint SET AdminP = '"+ newPassword +"' where AdminID = '"+username+ "'";
       
        flag = conn.InsertUpdateDelete(sql);
           if(flag == 1){
               JOptionPane.showMessageDialog(null, "YOUR PASSWORD HAS BEEN CHANGED  ");
           }
           else{
                JOptionPane.showMessageDialog(null, "YOUR PASSWORD COULDn't BE CHANGED" );
           }
        }
        catch(HeadlessException e){
             JOptionPane.showMessageDialog(null, "UpdatePassword Query Failed");
        }
        
    }
    public boolean chkAdminPass(String id, String pass){
        boolean flag = false;
        
        try{
            conn.OpenConnection();
            String sql = "Select AdminID,AdminP from AdminT where AdminID = '" + id + "' and AdminP = '" + pass + "'";
            rst= conn.GetData(sql);
            flag = rst.next();
            conn.CloseConnection();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e+"\nInavlid Username or Password");
        }
       return flag; 
    }
    public ResultSet RideRealTimeCombined()
    {
        ResultSet rst1;
        //rst1 = null;
    
        
        try{
            conn.OpenConnection();
            String sql = "Select Datee,Username,VehiclePlate,PUsername,Fromm,Too,StartTime,EndTime,RideStatus,BillStatus,Bill,NoOfPassengers from RideRealtime ";
            rst1= conn.GetData(sql);
                   do{
                return rst1;
            } 
            while(rst1.next());
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e+"\nRide Realtime Combined Error");
        }
          
        conn.CloseConnection();
        return null;
    }
    
}
