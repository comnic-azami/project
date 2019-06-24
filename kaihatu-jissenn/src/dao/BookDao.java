package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Book;
import javax.naming.NamingException;

public class BookDao {
	static String BASE_SQL ="SELECT * FROM book b JOIN registration r JOIN account a "+"WHERE r.isbn AND a.user_name=?";
    
    public static Book findByIsbn(String userName)throws DaoException {
            Book book = new Book();        
         String sql ="SELECT * FROM book b JOIN registration r JOIN account a "+"WHERE r.isbn AND a.user_name=?";
                                                                        
            try (Connection conn = ConnectionFactory.getConnection();
                            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1,userName);
                    try (ResultSet rs = pstmt.executeQuery()) {
                            if (rs.next()) {
                                    book.setIsbn(rs.getString("isbn"));
                                    book.setTitle(rs.getString("title"));
                                    book.setAutor(rs.getString("author"));
                                    
                            }
                    }
            } catch (NamingException | SQLException e) {
                    throw new DaoException(e);
            }
            return book;
    }
    
    public static ArrayList<Book> findAll() throws DaoException {
                            
            return findAllBy(BASE_SQL);
    }
    
    public static ArrayList<Book> findByTitle(String title) throws DaoException {
    
            String sql = BASE_SQL + "AND title like ?";
            return findAllBy(sql, "%" + title + "%");
    }
    private static ArrayList<Book> findAllBy(String sql, Object... params) throws DaoException {
            ArrayList<Book> bookList = new ArrayList<>();
            try (Connection conn = ConnectionFactory.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
                    if (params != null) {
                            int index = 1;
                            for (Object param : params) {
                                    pstmt.setObject(index++, param);
                            }
                    }
                    
                    try (ResultSet rs = pstmt.executeQuery()) {
                            while (rs.next()) {
                                    
                                    Book book = new Book(
                                            rs.getString("isbn"), 
                                            rs.getString("title"), 
                                            rs.getString("author")
                                    );
                                    
                                    bookList.add(book);
                            }
                    }
            } catch (NamingException | SQLException e) {
                    throw new DaoException(e);
            }
            return bookList;
    }
    
    
}