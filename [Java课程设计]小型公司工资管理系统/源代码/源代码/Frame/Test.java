package Frame;


import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Test{
    public static JTable table;   
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Table Header");
        table = new JTable(6,6);       
        TableRender render = new TableRender();
        table.setRowHeight(20);
        TableEditor editor = new TableEditor(new JTextField());
        table.getColumnModel().getColumn(3).setCellRenderer(render);
        table.getColumnModel().getColumn(3).setCellEditor(editor);
        editor.setClickCountToStart(0);
        JScrollPane pane = new JScrollPane(table);           
        frame.setContentPane(pane);
        frame.setPreferredSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);       
    }
}

class TableRender extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (row<0||column!=3)
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        else {
            JButton label = new JButton("button");
            label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(),20));
            return label;
        }       
    }
}

 class TableEditor extends DefaultCellEditor {
    public TableEditor(JCheckBox checkBox) {
        super(checkBox);
    }
    public TableEditor(JComboBox comboBox) {
        super(comboBox);
    }
    public TableEditor(JTextField textField) {
        super(textField);
    }
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (row<0||column!=3)
            return super.getTableCellEditorComponent(table, value, isSelected,  row, column);
        else {
            JButton label = new JButton("button");
            label.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    JOptionPane.showMessageDialog(null, "test");
                }               
            });
            label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(),20));
            return label;
        }
    }
}