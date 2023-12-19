package boards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDatabase2 {

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
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                String sql = "INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
                        "VALUES(?, ?, ?, now(), ?, ?)";

                pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, "눈오는 날");
                pstmt.setString(2, "함박눈이 내려요");
                pstmt.setString(3, "winter");
                pstmt.setString(4, "snow.jpg");

                try (FileInputStream fis = new FileInputStream("snow.jpg")) {
                    pstmt.setBlob(5, fis);

                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        rs = pstmt.getGeneratedKeys();
                        if (rs.next()) {
                            int generatedBno = rs.getInt(1);
                            System.out.println("저장된 bno: " + generatedBno);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("파일을 찾을 수 없습니다.");
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
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
