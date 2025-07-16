package stream.exam;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class NationApp extends JFrame {
    /**
     * @wbp.nonvisual location=256,279
     */
    private final JButton btnSort ;
    private JTable jTable;
    JComboBox<String> cmbOrder;

    NationApp() {
        setTitle("국가");

        add(new JScrollPane(makeTable()), BorderLayout.CENTER);


        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);

        String[] cmbString = {"국가별", "인구수","GDP"};
        cmbOrder = new JComboBox<String>(cmbString);


        panel.add(cmbOrder);

        btnSort  = new JButton("정렬");
        panel.add(btnSort);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setVisible(true);
        loadNationData();
        btnSort.addActionListener(e -> sortAndReloadTable());


    }
    /**
     *
     * @return
     */
    JTable makeTable() {
        if ( jTable == null) {
            jTable = new JTable();

            DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
            tableModel.addColumn("번호");
            tableModel.addColumn("국가명");
            tableModel.addColumn("유형");
            tableModel.addColumn("인구수");
            tableModel.addColumn("GDP순위");

            jTable.getColumn("번호").setPreferredWidth(30);
            jTable.getColumn("국가명").setPreferredWidth(100);
            jTable.getColumn("유형").setPreferredWidth(30);
            jTable.getColumn("인구수").setPreferredWidth(30);
            jTable.getColumn("GDP순위").setPreferredWidth(30);

            CenterTableCellRenderer ctcr = new CenterTableCellRenderer();
            jTable.getColumn("번호").setCellRenderer(ctcr);
            jTable.getColumn("국가명").setCellRenderer(ctcr);
            jTable.getColumn("유형").setCellRenderer(ctcr);
            jTable.getColumn("인구수").setCellRenderer(ctcr);
            jTable.getColumn("GDP순위").setCellRenderer(ctcr);
        }
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

    private void loadNationData() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        int index = 1;
        for (Nation n : Nation.nations) {
            model.addRow(new Object[]{
                    index++,
                    n.getName(),
                    n.getType(),
                    n.getPopulation(),
                    n.getGdpRank()
            });
        }
    }
    private void sortAndReloadTable() {
        String selected = (String) cmbOrder.getSelectedItem();

        List<Nation> sorted = Nation.nations.stream().toList();

        switch (selected) {
            case "국가별":
                sorted = sorted.stream()
                        .sorted(    Comparator.comparing(Nation::getName))
                        .toList();
                break;
            case "인구수":
                sorted = sorted.stream()
                        .sorted(Comparator.comparingDouble(Nation::getPopulation).reversed())
                        .toList();
                break;
            case "GDP":
                sorted = sorted.stream()
                        .sorted(Comparator.comparingInt(Nation::getGdpRank))
                        .toList();
                break;
        }


        updateTableWithList(sorted);
    }
    private void updateTableWithList(List<Nation> nations) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        int index = 1;
        for (Nation n : nations) {
            model.addRow(new Object[]{
                    index++,
                    n.getName(),
                    n.getType(),
                    n.getPopulation(),
                    n.getGdpRank()
            });
        }
    }
    public static void main(String[] args) {
        new NationApp();

    }

}
