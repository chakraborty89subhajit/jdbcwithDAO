package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentJDBCDAO {
    Connection connection= null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;


    public StudentJDBCDAO(){

    }

    private Connection getConnection() {
        Connection con = null;
        try {
            con = ConnectionFactory.getInstance().getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void add(StudentBean studentBean){
        try{
            String queryString="insert into Students(LastName,FirstName,Age)values(?,?,?)";
            connection=getConnection();
            pstmt=connection.prepareStatement(queryString);
            pstmt.setString(1,studentBean.getLastName());
            pstmt.setString(2,studentBean.getFirstName());
            pstmt.setInt(3,studentBean.getAge());
            int res = pstmt.executeUpdate();
            System.out.println(res+" column added successfully");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt!=null){
                    pstmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch(Exception e ){
                e.printStackTrace();
            }
        }
    }


    public void update(StudentBean studentBean){
        try{
            String queryString ="update students set LastName=?,FirstName=?,Age=? where FirstName=?";
            connection=getConnection();
            pstmt=connection.prepareStatement(queryString);
            pstmt.setString(1,studentBean.getLastName());
            pstmt.setString(2,studentBean.getFirstName());
            pstmt.setInt(3,studentBean.getAge());
            pstmt.setString(4,studentBean.getFirstName());
            int res=pstmt.executeUpdate();
            if(res>0) {
                System.out.println("table successfully updated");
            }else{
                System.out.println("unable to update table");
            }
        }catch(Exception e){
          e.printStackTrace();
        }finally{
            try{
               if(pstmt!=null){
                   pstmt.close();
               }
               if(connection!=null){
                   connection.close();
               }
            }catch(Exception e ){
                e.printStackTrace();
            }
        }
    }


    public void delete(String FirstName){
        try{
            String queryString="delete from students where FirstName=?";
            connection=getConnection();
            pstmt=connection.prepareStatement(queryString);
            pstmt.setString(1,FirstName);
           int res= pstmt.executeUpdate();
           if(res>0){
               System.out.println(res+" column deleted successfully");
           }else{
               System.out.println("unable to delete data");
           }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt!=null){
                    pstmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch(Exception e ){
                e.printStackTrace();
            }
        }

    }



    public void findAll(){

        try{
            String queryString="select * from students";
            connection=getConnection();
            pstmt=connection.prepareStatement(queryString);
            rs=pstmt.executeQuery();
            System.out.println("-----------------------------");
            while(rs.next()){
                System.out.println("id:"+rs.getInt("id"));
                System.out.println("last name:"+rs.getString("LastName"));
                System.out.println("first name:"+rs.getString("FirstName"));
                System.out.println("age:"+rs.getInt("Age"));
                System.out.println("===========================");
            }

        }catch(Exception e ){
            e.printStackTrace();
        }finally{
            try{
                if(rs!=null){
                    rs.close();

                }
                if(pstmt!=null){
                    pstmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch(Exception e ){
                e.printStackTrace();
            }
        }

    }

}
