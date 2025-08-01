package boardapp.model;

import sec01.Dao.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BoardmapDbHelper {
    private static final String db_hostname = "localhost";
    private static final int db_portnumber = 3306;
    private static final String db_database = "school";
    private static final String db_charset = "utf8";
    private static final String db_username = "root";
    private static final String db_password = "1234";

    private Connection conn = null; // null로 초기화 한다.

    // ------------ 싱글톤 객체 시작 --------------
    private static BoardmapDbHelper current;
    public static BoardmapDbHelper getInstance() {
        if (current == null) {
            current = new BoardmapDbHelper();
        }
        return current;
    }
    public static void freeInstance() {
        current = null;
    }
    private BoardmapDbHelper() { }
    // ------------ 싱글톤 객체 끝 --------------

    /* 데이터베이스에 접속 후, 접속 객체 return */
    public Connection open() {
        if (conn == null) {

            /* 데이터베이스 접속 */
            // 사용하려는 데이터베이스명을 포함한 URL
            String urlFormat = "jdbc:mysql://%s:%d/%s?&characterEncoding=%s";
            String url = String.format(urlFormat, db_hostname, db_portnumber,
                    db_database, db_charset);

            // 접속 과정에서 예외처리가 요구된다.
            try {
                // DBDriver 구동
                Class.forName("com.mysql.cj.jdbc.Driver");
                // DriverManager 객체를 사용하여 DB에 접속
                conn = DriverManager.getConnection(url, db_username, db_password);
                System.out.println("=== DATABASE Connect Success ===");
            } catch (ClassNotFoundException e) {
                System.out.println("=== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                System.out.println("=== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }

    /* 데이터베이스 접속 해제 */
    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("=== DATABASE Disconnect Success ===");
            } catch (Exception e) {
                System.out.println("=== DATABASE Disconnect Fail ===");
                System.out.println(e.getMessage());
            }
            conn = null;
        }
    }
}