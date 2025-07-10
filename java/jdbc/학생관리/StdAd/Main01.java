package sec01.StdAd;

import java.sql.Connection;

public class Main01 {
    public static void main(String[] args) {
        // 1) 데이터베이스 접속
        // --> import java.sql.Connection;
        // --> import study.java.helper.DBHelper;
        Connection conn = DbHelper.getInstance().open();

        if (conn == null) {
            System.out.println("데이터베이스 접속 실패");
            return;
        }

        // 2) INSERT를 수행할 데이터 생성
        // --> 사용되지 않는 값(deptno)는 0(int)이나 null(String)로 지정한다.
        Student model = new Student(105, "이용수", "010351351","lyslyslys");

        // 3) 데이터 저장
        StudentDao dao = new StudentDaoImpl(conn);
        int result = dao.insert(model);

        // 4) 결과 판별
        System.out.println(result+ "번 데이터 저장됨");

        // 5) DB 접속 해제
        DbHelper.getInstance().close();
    }
}