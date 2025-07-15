package boardapp.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import boardapp.model.BoardmapDaoImp;
import boardapp.model.BoardmapDbHelper;
import boardapp.model.BoardmapDto;


public class DbManager {
    private static DbManager dbManager;
    BoardmapDaoImp boardImp;
    Connection conn;

    List<BoardmapDto> boardList ;

    private DbManager() {
        conn = BoardmapDbHelper.getInstance().open();
        boardImp = new BoardmapDaoImp(conn);
    }

    public static DbManager getInstance() {
        if (dbManager == null) {
            dbManager = new DbManager();
        }
        return dbManager;
    }

    /**
     *
     */
    public void loadDataToJTable( JTable jtable) {
        boardList = boardImp.select();
        DefaultTableModel tableModel = (DefaultTableModel)jtable.getModel();

        for (BoardmapDto item: boardList ) {
            Object[] rowData ={item.getId(), item.getTitle(),item.getAuthor(), item.getDate(),item.getViews()};
            tableModel.addRow(rowData);
        }
    }

    public BoardmapDto getBoardOne(int nIndex) {
        return boardList.get(nIndex);
    }
}