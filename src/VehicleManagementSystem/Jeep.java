/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleManagementSystem;

/**
 *
 * @author user
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class Jeep extends Vehicle{
    private String JeepName;
    private int totalJeeps;
    PreparedStatement pst = null;
    ResultSet rst = null;
    Jeep()
    {
        
    }
    Jeep(String Model,String Version,String Color,String plateNo,String registrationDate,String expirationDate, String JeepName)
    {
        super(Model,Version,Color,plateNo,registrationDate,expirationDate);
        this.JeepName=JeepName;
        
    }
    Jeep(int totalJeeps)
    {
        this.totalJeeps=totalJeeps;
    }
    public void addJeep()
    {
        
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Insert into JeepT (Model,Version,Color,PlateNo,RegistrationDate,ExpirationDate,JeepName) values ' "
                    + super.getModel()+ "','"
                    + super.getVersion()+ "','"
                    + super.getColor()+ "','"
                    + super.getPlateNo()+ "','"
                    + super.getregistrationDate()+ "','"
                    + super.getExpirationDate()+ "','"
                    + getJeepName()+ "'";
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               JOptionPane.showMessageDialog(null, "You Have Successfully Added "+getJeepName()+" "+super.getModel());
           }
           else{
               JOptionPane.showMessageDialog(null, "Jeep Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
    }
    public int assignJeep()
    {
        
        
        int newAss=1;
        int ass=5;
        int total=0;
        int i=1;
        
//        for( i=1;i<2;i++)
        
                        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="SELECT TOP 1 JeepId FROM JeepT ORDER BY JeepId DESC"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           total=rst.getInt("JeepId");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCouldn't Select Last JeepId");  
        }
        total=total+1;

        while(i<total)
        { 
            
               try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Assigned from JeepT where JeepId = '"+ i + "'"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           ass=rst.getInt("Assigned");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Jeep ID Error");  
        }
    
               
        
               
               
               if(ass==0)
               {
                   break;
               }
           
               i++;
        }
        DbConnection conn = new DbConnection();
        int flag;
        try{
        conn.OpenConnection();
        String sql = "UPDATE JeepT SET Assigned = '"+ newAss +"' where JeepId = '"+i+ "'";
       
        flag = conn.InsertUpdateDelete(sql);
           if(flag == 1){
               JOptionPane.showMessageDialog(null, "Jeep's Availablity Updated  ");
           }
           else{
                JOptionPane.showMessageDialog(null, "Jeep's Availablity Couldn't Updatedr " );
           }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "Update Query Failed");
        }
        return i;
               
    }
    
    public String getJeepName()
    {
        return JeepName;
    }
    public String getRModel(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Model from JeepT where JeepId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Model");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Jeep ID Error");  
        }
        return ass;
    }
    public String getRVersion(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Version from JeepT where JeepId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Version");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Jeep ID Error");  
        }
        return ass;
    }
    public String getRColor(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Color from JeepT where JeepId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Color");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Jeep ID Error");  
        }
        return ass;
    }
    public String getRPlateNo(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select PlateNo from JeepT where JeepId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("PlateNo");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Jeep ID Error");  
        }
        return ass;
    }
    public String getRRDate(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select RegistrationDate from JeepT where JeepId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("RegistrationDate");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Jeep ID Error");  
        }
        return ass;
    }
    public String getEDate(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select ExpirationDate from JeepT where JeepId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("ExpirationDate");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Jeep ID Error");  
        }
        return ass;
    }
    public String getJeepName(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select JeepName from JeepT where JeepId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("JeepName");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Jeep ID Error");  
        }
        return ass;
    }
    public void deleteJeep(int id )
     {
     
    
     
     try
        {
        DbConnection con = new DbConnection();
        con.OpenConnection();
        String sql = "DELETE from JeepT WHERE JeepId = '"+id+"'";
        
         
        int flagg=con.InsertUpdateDelete(sql);
                 
           if(flagg==1){
               JOptionPane.showMessageDialog(null, "Jeep Deleted");
           }
           else{
               JOptionPane.showMessageDialog(null, "Please Enter A Valid JeepId");
           }
           con.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
     }
     public ResultSet getJeepData()
     {
         DbConnection conn = new DbConnection();
        try{
            conn.OpenConnection();
            String select_sql = "Select JeepId,Model,PlateNo,JeepName from JeepT ";
            rst=conn.GetData(select_sql);
            do{
                return rst;
            } while(rst.next());
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "GetJeepData Query Failed");
        }
        conn.CloseConnection();
        return null;
         
     }
}
