package boardapp.view;

import boardapp.controller.DbManager;
import boardapp.model.BoardmapDto;
import boardapp.view.ViewDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;



public class BoardApp extends JFrame {
    private JTable jTable;
    private JPanel pSouth;
    private JButton btnInsert;
    DbManager dbManager;

    //private List<Board> list = new ArrayList<Board>();

    BoardApp(){

        dbManager = DbManager.getInstance();

        setTitle("게시판 리스트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
        getContentPane().add(getPSouth(), BorderLayout.SOUTH);
        setSize(600, 450);
        setVisible(true);

    }
    /**
     *
     * @return
     */
    JTable getJTable() {
        if(jTable == null) {
            jTable = new JTable();


            DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
            tableModel.addColumn("번호");
            tableModel.addColumn("제목");
            tableModel.addColumn("글쓴이");
            tableModel.addColumn("날짜");
            tableModel.addColumn("조회수");

            jTable.getColumn("번호").setPreferredWidth(20);
            jTable.getColumn("제목").setPreferredWidth(250);
            jTable.getColumn("글쓴이").setPreferredWidth(50);
            jTable.getColumn("날짜").setPreferredWidth(50);
            jTable.getColumn("조회수").setPreferredWidth(20);

            CenterTableCellRenderer ctcr = new CenterTableCellRenderer();
            jTable.getColumn("번호").setCellRenderer(ctcr);
            jTable.getColumn("제목").setCellRenderer(ctcr);
            jTable.getColumn("글쓴이").setCellRenderer(ctcr);
            jTable.getColumn("날짜").setCellRenderer(ctcr);
            jTable.getColumn("조회수").setCellRenderer(ctcr);



            ///////////////////////////////////////////////////////
            jTable.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int rowIndex = jTable.getSelectedRow();
                    if(rowIndex !=-1) {
                        BoardmapDto board = dbManager.getBoardOne(rowIndex);
                        ViewDialog viewDialog = new ViewDialog(BoardApp.this);
                        viewDialog.setBoard(board);
                        viewDialog.setVisible(true);
                    }
                }
            });

            ///////////////////////////////////////////////////////
        }

        dbManager.loadDataToJTable(jTable);
        return jTable;
    }
    /**
     *
     */
    public class CenterTableCellRenderer extends JLabel implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            setFont(new Font(null, Font.PLAIN, 12));
            setHorizontalAlignment(JLabel.CENTER);
            setOpaque(true);
            if(isSelected) { setBackground(Color.YELLOW); }
            else { setBackground(Color.WHITE); }
            return this;
        }
    }
    /**
     *
     * @return
     */
    public JPanel getPSouth() {
        if(pSouth == null) {
            pSouth = new JPanel();
            pSouth.add(getBtnInsert());
        }
        return pSouth;
    }

    /**
     *
     * @param args
     */
    public JButton getBtnInsert() {
        if(btnInsert == null) {
            btnInsert = new JButton();
            btnInsert.setText("추가");
            btnInsert.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ViewDialog viewDialog = new ViewDialog(BoardApp.this);
                    viewDialog.setVisible(true);
                }
            });
        }
        return btnInsert;
    }
    public static void main(String[] args) {
        new BoardApp();

    }

}