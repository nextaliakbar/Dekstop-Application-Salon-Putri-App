/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

import event.TableEvent;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author usER
 */
public class TableCellEditor extends DefaultCellEditor{
    private TableEvent event;
    private boolean showEdit;
    private boolean showDelete;
    private boolean showView;
    public TableCellEditor(TableEvent event, boolean showEdit, boolean showDelete, boolean showView) {
        super(new JCheckBox());
        this.event = event;
        this.showEdit = showEdit;
        this.showDelete = showDelete;
        this.showView = showView;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelEvent eventTable = new PanelEvent(showEdit,showDelete, showView);
        eventTable.initiationAction(event, row);
        eventTable.setBackground(table.getSelectionBackground());
        return eventTable;
    }
}
