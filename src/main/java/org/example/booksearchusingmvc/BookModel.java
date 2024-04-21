package org.example.booksearchusingmvc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private static Connection conn;
    private static PreparedStatement ps;

    static{
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-CVA9M52B:1521/xe","advjava","advjava");
            ps = conn.prepareStatement("select * from allbooks where subject = ?");
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static List<BookPojo> getAllBooksBySubject(String subject) throws SQLException{
        ps.setString(1,subject);
        ResultSet rs = ps.executeQuery();
        List<BookPojo> bookList = new ArrayList<BookPojo>();
        while(rs.next()){
            BookPojo book = new BookPojo();
            book.setBookId(rs.getInt("bookid"));
            book.setBookName(rs.getString("bookname"));
            book.setBookPrice(rs.getDouble("bookprice"));
            book.setSubject(rs.getString("subject"));
            bookList.add(book);
        }
        return bookList;
    }

    public static void closConnection(){
        try{
            conn.close();
            System.out.println("Done!");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
