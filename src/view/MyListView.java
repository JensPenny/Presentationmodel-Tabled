package view;

import carexample.view.CarTableCellEditor;
import com.jgoodies.common.collect.ArrayListModel;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Universitaire Ziekenhuizen Leuven
 * Date: 2/05/12
 */
public class MyListView<E> {
    private JComponent gui;
    private final ArrayListModel<E> listModel;

    public MyListView(final Class<E> clazz, final MyTableModelFactory<E> factory, final List<E> modelList,
                      final TableCellRenderer cellRenderer,
                      final TableCellEditor cellEditor) {

        listModel = new ArrayListModel<E>(modelList);
        TableModel model  = factory.createModel(listModel);
        JTable table = new JTable();
        table.setModel(model);
        table.setDefaultRenderer(clazz, cellRenderer);
        table.setDefaultEditor(clazz, cellEditor);
        table.setRowHeight(50);
        table.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.<AWTKeyStroke>emptySet());
        table.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, Collections.<AWTKeyStroke>emptySet());
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "none");
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, InputEvent.SHIFT_DOWN_MASK), "none");
        gui = new JScrollPane(table);
    }

    public List<E> getObjects(){
        return new ArrayList<E>(listModel);
    }
    
    public JComponent getGui(){
        return gui;
    }
}