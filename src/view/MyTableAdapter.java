package view;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.common.collect.ArrayListModel;

/**
 * Universitaire Ziekenhuizen Leuven
 * Date: 2/05/12
 */
public abstract class MyTableAdapter<E> extends AbstractTableAdapter<E> {
    public MyTableAdapter(final ArrayListModel<E> objectList) {
        super(objectList);
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public E getValueAt(final int rowIndex, final int columnIndex) {
        return getRow(rowIndex);
    }

    @Override
    public boolean isCellEditable(final int columnIndex, final int rowIndex) {
        return true;
    }
}
