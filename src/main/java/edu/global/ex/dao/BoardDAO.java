package edu.global.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAO {

   // private DataSource dataSource;
   private String url = "jdbc:oracle:thin:@localhost:1521:xe";
   private String uid = "scott";
   private String upw = "tiger";

   public BoardDAO() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public List<BoardVO> boardSelect(){
      List<BoardVO> boards = new ArrayList<BoardVO>();
      
      Connection con = null;
      Statement stmt = null;
      ResultSet resultSet = null;
      
      try {
         String sql = "Select * from mvc_board";
         
         con = DriverManager.getConnection(url, uid, upw);         
         stmt = con.createStatement();
         resultSet = stmt.executeQuery(sql);
         
         while(resultSet.next()) {
            int bid = resultSet.getInt("bid");
            
            String bname = resultSet.getString("bname");
            String btitle = resultSet.getString("btitle");
            String bcontent = resultSet.getString("bcontent");
            
            Timestamp bdate = resultSet.getTimestamp("bdate");
                  
            int bhit = resultSet.getInt("bhit");
            int bgroup = resultSet.getInt("bgroup");
            int bstep = resultSet.getInt("bstep");
            int bindent = resultSet.getInt("bindent");
            
            BoardVO vo = new BoardVO(bid, bname,btitle, bcontent,bdate,bhit,bgroup,bstep,bindent);
            boards.add(vo);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) 
               resultSet.close();
            
            if(stmt != null) 
               stmt.close();
            
            if(con != null) 
               con.close();
            
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      return boards;      
   }
   
}