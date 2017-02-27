package com.sxy;



import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

/**
 * Created by Administrator on 2017/2/27.
 */
public class Test {

    @org.junit.Test
    public void testQuery(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql:///db_22","root","root");
            String sql="{call procedureavg()}";

            CallableStatement st=conn.prepareCall(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                String school=rs.getString("school");
                String tel=rs.getString("tel");
                System.out.println(school+"->"+tel);

            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public  void testInQuery(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql:///db_22","root","root");

            String sql="{call school_1(?,?)}";
            CallableStatement st=conn.prepareCall(sql);
            st.setString(1,"清华");
            st.setString(2,"3456");

         st.executeUpdate();
         st.close();
         conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public  void testOutQuery(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql:///db_22","root","root");
            String sql="{call school_3(?,?)}";
            CallableStatement st=conn.prepareCall(sql);

            st.registerOutParameter(1,Types.BIGINT);
            st.registerOutParameter(2,Types.BIGINT);
            st.executeUpdate();
            int max=st.getInt(1);
            int min=st.getInt(2);
            System.out.println(max+"->"+min);
            st.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
