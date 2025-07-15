package boardapp.view;


import boardapp.model.BoardmapDao;
import boardapp.model.BoardmapDaoImp;
import boardapp.model.BoardmapDto;
import sec01.Dao.DbHelper;
import sec01.Dao.Department;
import sec01.Dao.DepartmentDao;
import sec01.Dao.DepartmentDaoImpl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class InsertDialog extends JDialog {
    private BoardApp boardApp;
    private JPanel pCenter, pTitle, pContent, pWriter, pSouth;
    private JTextField txtTitle, txtWriter;
    private JTextArea txtContent;
    private JButton btnOk, btnCancel;

    public InsertDialog(BoardApp boardApp) {
        super(boardApp);
        this.boardApp = boardApp;
        this.setTitle("게시물 작성");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setModal(true);
        this.setSize(400, 270);

        this.setLocation(
                boardApp.getLocationOnScreen().x + (boardApp.getWidth()-this.getWidth())/2,
                boardApp.getLocationOnScreen().y + (boardApp.getHeight()-this.getHeight())/2
        );

        this.getContentPane().add(getPCenter(), BorderLayout.CENTER);
        this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
    }
    public JPanel getPCenter() {
        if(pCenter==null) {
            pCenter = new JPanel();
            pCenter.setBorder(new EmptyBorder(10,10,10,10));
            pCenter.add(getPTitle());
            pCenter.add(getPWriter());
            pCenter.add(getPContent());
        }
        return pCenter;
    }

    public JPanel getPTitle() {
        if(pTitle==null) {
            pTitle = new JPanel();
            pTitle.setLayout(new BorderLayout());
            JLabel label = new JLabel("제목");
            label.setAlignmentX(JLabel.CENTER);
            label.setPreferredSize(new Dimension(70, 30));
            label.setHorizontalAlignment(JLabel.CENTER);
            pTitle.add(label, BorderLayout.WEST);
            txtTitle = new JTextField();
            txtTitle.setPreferredSize(new Dimension(300, 30));
            pTitle.add(txtTitle, BorderLayout.CENTER);
        }
        return pTitle;
    }

    public JPanel getPWriter() {
        if(pWriter==null) {
            pWriter = new JPanel();
            pWriter.setLayout(new BorderLayout());
            JLabel label = new JLabel("글쓴이");
            label.setAlignmentX(JLabel.CENTER);
            label.setPreferredSize(new Dimension(70, 30));
            label.setHorizontalAlignment(JLabel.CENTER);
            pWriter.add(label, BorderLayout.WEST);
            txtWriter = new JTextField();
            txtWriter.setPreferredSize(new Dimension(300, 30));
            pWriter.add(txtWriter, BorderLayout.CENTER);
        }
        return pWriter;
    }

    public JPanel getPContent() {
        if(pContent == null) {
            pContent = new JPanel();
            pContent.setLayout(new BorderLayout());
            JLabel label = new JLabel("내용");
            label.setAlignmentX(JLabel.CENTER);
            label.setPreferredSize(new Dimension(70, 30));
            label.setHorizontalAlignment(JLabel.CENTER);
            pContent.add(label, BorderLayout.WEST);
            txtContent = new JTextArea();
            txtContent.setBorder(new EtchedBorder());
            txtContent.setPreferredSize(new Dimension(300, 100));
            pContent.add(txtContent, BorderLayout.CENTER);
        }
        return pContent;
    }

    public JPanel getPSouth() {
        if(pSouth == null) {
            pSouth = new JPanel();
            pSouth.setBackground(Color.WHITE);
            pSouth.add(getBtnOk());
            pSouth.add(getBtnCancel());
        }
        return pSouth;
    }

    public JButton getBtnOk() {
        if(btnOk == null) {
            btnOk = new JButton();
            btnOk.setText("저장");
            btnOk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Connection conn = DbHelper.getInstance().open();

                    if (conn == null) {
                        System.out.println("데이터베이스 접속 실패");
                        return;
                    }

                    // 2) INSERT를 수행할 데이터 생성
                    // --> 사용되지 않는 값(deptno)는 0(int)이나 null(String)로 지정한다.
                    BoardmapDto model = new BoardmapDto();
                    model.setAuthor(txtWriter.getText());
                    model.setContent(txtContent.getText());
                    model.setTitle(txtTitle.getText());

                    // 3) 데이터 저장
                    BoardmapDao dao = new BoardmapDaoImp(conn);
                    int result = dao.insert(model);

                    // 4) 결과 판별
                    System.out.println(result+ "번 데이터 저장됨");

                    // 5) DB 접속 해제
                    DbHelper.getInstance().close();
                    dispose();
                }
            });
        }
        return btnOk;
    }

    public JButton getBtnCancel() {
        if(btnCancel == null) {
            btnCancel = new JButton();
            btnCancel.setText("취소");
            btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }
        return btnCancel;
    }
}
