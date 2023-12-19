package boards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDatabase5 {
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/boards";
        String id = "root";
        String password = "";

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }
        return con;
    }

    public static void main(String arg[]) throws SQLException, IOException {
        Connection con = makeConnection();
        if (con != null) {
            try {
                String sql = "UPDATE boards SET " +
                        "btitle=?, " +
                        "bcontent=?, " +
                        "bfilename=?, " +
                        "bfiledata=? " + // Removed the misplaced parenthesis
                        "WHERE bno=?";

                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, "눈사람");
                pstmt.setString(2, "눈으로 만든 사람");
                pstmt.setString(3, "snowman.jpg");

                try {
                    FileInputStream fis = new FileInputStream("snowman.jpg");
                    pstmt.setBinaryStream(4, fis);

                    pstmt.setInt(5, 1);
                    int rows = pstmt.executeUpdate();
                    System.out.println("수정된 행 수: " + rows);

                    pstmt.close();
                    fis.close(); // Close the FileInputStream
                } catch (FileNotFoundException e) {
                    System.out.println("파일을 찾을 수 없습니다.");
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Connection is null. Cannot proceed.");
        }
    }
}

    