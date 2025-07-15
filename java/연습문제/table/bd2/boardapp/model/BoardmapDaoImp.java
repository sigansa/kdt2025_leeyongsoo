package boardapp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardmapDaoImp implements BoardmapDao{
    /** 데이터 베이스 접속 객체 */
    private Connection conn;

    /** 생성자를 통해서 데이터베이스 접속 객체를 전달 받는다.*/
    public BoardmapDaoImp (Connection conn) {
        this.conn = conn;
    }


    @Override
    public int insert(BoardmapDto params) {
        int result = 0;

        /** 실행할 SQL구문 정의*/
        String sql = "INSERT INTO boardmap (title,author,date,content) VALUES(?,?, CURRENT_TIMESTAMP,?)";

        /** SQL 구문 실행하기 위한 객체*/
        // -->import java.sql.preparedStatement;
        PreparedStatement pstmt = null;
        // -->import java.sql.ResultSet;
        ResultSet rs = null;

        /** SQL 구문 처리하기*/

        try {
            // pstmt 객체 할당
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // 템플릿에 데이터 설정
            pstmt.setString(1, params.getTitle());
            pstmt.setString(2, params.getAuthor());
            pstmt.setString(3, params.getContent());


            // SQL문 실행하기 --> 결과 행의 수를 리턴할 변수에 대입함
            pstmt.executeUpdate();

            // Primary Key 받기
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            } else {
                System.out.println("생성된 키가 없습니다.");
            }
            result = rs.getInt(1);

        } catch (SQLException e) {
            System.out.println("MySQL SQL Fail : " + e.getMessage());
        } finally {
            if(rs != null) {
                // 객체 닫기
                try {
                    rs.close();
                } catch (Exception e) {}
            }
            if (pstmt != null) {
                // 객체 닫기
                try {
                    pstmt.close();
                } catch (SQLException e) {}
            }
        }

        return result;
    }

    @Override
    public int delete(int params) {
        int result = 0;

        /** 실행할 SQL 구문 정의 */
        String sql = "DELETE FROM boardmap WHERE id=?";

        /** SQL 구문 실행하기 위한 객체 */
        // --> import java.sql.PreparedStatement;
        PreparedStatement pstmt = null;

        /** SQL 구문 처리하기 */
        try {
            // pstmt 객체 할당
            pstmt = conn.prepareStatement(sql);

            // 템플릿에 데이터 설정
            pstmt.setInt(1, params);

            // SQL문 실행하기 --> 결과 행의 수를 리턴할 변수에 대입함
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("MySQL SQL Fail : " + e.getMessage());
        } finally {
            if (pstmt != null) {
                // 객체 닫기
                try {
                    pstmt.close();
                } catch (SQLException e) {}
            }
        }

        return result;
    }

    @Override
    public int update(BoardmapDto params) {
        int result = 0;

        /** 실행할 SQL 구문 정의 */
        String sql = "UPDATE boardmap SET title=?, author=?,content=? WHERE deptno=?";

        /** SQL 구문 실행하기 위한 객체 */
        // --> import java.sql.PreparedStatement;
        PreparedStatement pstmt = null;

        /** SQL 구문 처리하기 */
        try {
            // pstmt 객체 할당
            pstmt = conn.prepareStatement(sql);

            // 템플릿에 데이터 설정
            pstmt.setString(1, params.getTitle());
            pstmt.setString(2, params.getAuthor());
            pstmt.setString(3, params.getContent());

            // SQL문 실행하기 --> 결과 행의 수를 리턴할 변수에 대입함
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("MySQL SQL Fail : " + e.getMessage());
        } finally {
            if (pstmt != null) {
                // 객체 닫기
                try {
                    pstmt.close();
                } catch (SQLException e) {}
            }
        }
        return result;
    }

    @Override
    public BoardmapDto selectOne(int params) {return null;
    }


    @Override
    public List<BoardmapDto> select() {
        List<BoardmapDto> result = null;
        String sql ="select * from boardmap"  ;
        PreparedStatement pstmt =null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql );
            rs = pstmt.executeQuery();

            result = new ArrayList<BoardmapDto>();
            while(rs.next()) {
                BoardmapDto item = new BoardmapDto();
                item.setId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setAuthor(rs.getString("author"));
                item.setContent(rs.getString("content"));
                item.setDate(rs.getString("date"));
                item.setViews(rs.getInt("views"));

                result.add(item);
            }

        }catch (SQLException e) {
            System.out.println("fail : " + e.getMessage());
        } finally {
            try {
                if ( rs != null)
                    rs.close();
            }catch(SQLException e) {}

            try {
                if ( pstmt != null)
                    pstmt.close();
            }catch(SQLException e) {}
        }

        return result;
    }

}
