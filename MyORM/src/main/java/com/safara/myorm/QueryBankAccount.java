package com.safara.myorm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author safoura
 */
public class QueryBankAccount {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:postgresql://localhost:5432/banking";
        String username = "postgres";
        String password = "postgres";
        
        String tbl;
        String sql;
        ArrayList<String> columns = new ArrayList<>();
        
        Connection con = DriverManager.getConnection(url, username, password);
                
        Class<BackAccountEntity> bankAccountEntity = BackAccountEntity.class;
        
        Annotation tableAnnotation = bankAccountEntity.getAnnotation(Table.class);
        Table table = (Table) tableAnnotation;
        

        tbl = table.name();
        
    
	for (Method method : bankAccountEntity.getDeclaredMethods()) {

        
            if (method.isAnnotationPresent(Column.class)) {

                Annotation columnAnnotation = method.getAnnotation(Column.class);
                Column column = (Column) columnAnnotation;


                columns.add(column.name());

            }
            
        }
        
        String columnsString = "";

        for (int i = 0; i < columns.size(); i++) {
            columnsString += columns.get(i);
            if ( i != (columns.size()-1))
                columnsString += ",";
        }
        
        sql = "SELECT " + columnsString + " FROM " + tbl;
        
        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet resultSet = stmt.executeQuery();
        
        String row;
        
        while (resultSet.next()) {
            
            row = columns.get(0) + " : " + resultSet.getInt(1);
            row += ", " + columns.get(1) + ": " + resultSet.getString(2);
            row += ", " + columns.get(2) + ": " + resultSet.getLong(3);
            
            System.out.println(row);
        }

        resultSet.close();
        stmt.close();
        con.close();

    }
    
}
