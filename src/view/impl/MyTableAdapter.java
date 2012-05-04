package view.impl;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.common.collect.ArrayListModel;

/**
 * Universitaire Ziekenhuizen Leuven
 * Date: 2/05/12
 */
class MyTableAdapter<E> extends AbstractTableAdapter<E> {
    private final Class<E> clazz;


    public MyTableAdapter(final Class<E> clazz, final ArrayListModel<E> objectList) {
        super(objectList);
        this.clazz = clazz;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "I'll be hided";
    }

    public E getValueAt(final int rowIndex, final int columnIndex) {
        return getRow(rowIndex);
    }

    @Override
    public boolean isCellEditable(final int columnIndex, final int rowIndex) {
        return true;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return clazz;
    }
}
