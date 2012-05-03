package view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

/**
 * Universitaire Ziekenhuizen Leuven
 * Date: 2/05/12
 */
public class MyJTable extends JTable {

    @Override
    public void columnMarginChanged(final ChangeEvent e) {
        if (!isEditing()) {
            super.columnMarginChanged(e);
        }
    }

    public void startEditing(final int row) {
        if (isEditing() ) {
            editCellAt(row, 0);
            final CellEditor editor = getCellEditor(row, 0);
            editor.shouldSelectCell(new ListSelectionEvent(this, row, row, false));
        }
    }
}
