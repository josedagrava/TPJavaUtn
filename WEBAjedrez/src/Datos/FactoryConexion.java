package Datos;

import java.sql.*;

public class FactoryConexion {
	
	private String dbDriver= "com.mysql.jdbc.Driver";
    private String host= "localhost";
    private String port= "3306";
    private String user= "java";
    private String pass="1234";
    private String db= "ajedrez";
    
    private Connection conn;
    private int cantCon;
    
    private FactoryConexion(){
    	try{
    		Class.forName(dbDriver);
    		conn=null;
    		cantCon=0;
    		
    	   }catch(ClassNotFoundException e){
    		e.printStackTrace();
    									   }
        }
    
   private static FactoryConexion instancia;
   
   public static FactoryConexion getInstancia(){
	  
	   if(instancia==null){
		    instancia = new FactoryConexion();
	   }
	   return instancia;
	   
	 }
   
   public Connection getConn(){
	   try{
		   if(conn==null || conn.isClosed()){
			   conn= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?user=root");//+user+"&password="+pass);
				cantCon++;
		   }
	   }catch(SQLException e){
		   e.printStackTrace();
	   }
	   
	  return conn;
	    }
   
   public void releaseConn(){
	   try{
		  cantCon--;
		  if(cantCon==0){
			  conn.close();
		  	}
		  
	      } catch(SQLException e){
	    	  e.printStackTrace();
		   
	      		}
   }
}
