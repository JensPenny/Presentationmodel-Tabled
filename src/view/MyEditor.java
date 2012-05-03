package view;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.util.EventObject;

/**
 * Universitaire Ziekenhuizen Leuven
 * Date: 2/05/12
 */
public abstract class MyEditor<E> extends AbstractCellEditor implements TableCellEditor {
    private E model;
    private MyJTable myjt;

    private EditorViewContract<E> view;


    @Override
    public Component getTableCellEditorComponent(final JTable table, final Object value, final boolean isSelected, final int row, final int column) {
        model = (E) value;
        view = prepareEditor((E) value);
        myjt = (MyJTable) table;
        try {
            KeyboardFocusManager.setCurrentKeyboardFocusManager(createKeyBoardFocusManager());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return getGui();
    }

    protected abstract EditorViewContract<E> prepareEditor(E e);

    protected KeyboardFocusManager createKeyBoardFocusManager() {
        return new DefaultKeyboardFocusManager() {
            @Override
            public void focusNextComponent(Component aComponent) {
                if (isLastComponent(aComponent)) {
                    final int row = getMyjt().getSelectedRow() + 1;
                    if (row < getMyjt().getRowCount()) {
                        getMyjt().getSelectionModel().setSelectionInterval(row, row + 1);
                        getMyjt().startEditing(row);
                    } else {
                        stopCellEditing();
                        Container ancestor = getMyjt().getFocusCycleRootAncestor();
                        Component cmp = ancestor.getFocusTraversalPolicy().getComponentAfter(ancestor, getMyjt());
                        cmp.transferFocus();
                    }
                } else {
                    super.focusNextComponent(aComponent);
                }
            }
        };
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public boolean stopCellEditing() {
        try {
            KeyboardFocusManager.setCurrentKeyboardFocusManager(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return super.stopCellEditing();
    }

    public E getModel() {
        return model;
    }

    public MyJTable getMyjt() {
        return myjt;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        view.requestFocus();
        return true;
    }

    public JComponent getGui() {
        return view.getGui();
    }

    public boolean isLastComponent(Component aComponent) {
        return view.isLastComponent(aComponent);
    }
}
