package view.impl;


import com.jgoodies.common.collect.ArrayListModel;
import view.EditableListView;
import view.EditorViewContractFactory;
import view.ViewContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Universitaire Ziekenhuizen Leuven
 * Date: 2/05/12
 */
public class EditableListViewImpl<E>  {
    private JComponent gui;
    private final ArrayListModel<E> listModel;

    public EditableListViewImpl(final Class<E> clazz, final List<E> modelList,
                                final ViewContract<E> viewContract,
                                final EditorViewContractFactory<E> editorViewContractFactory) {

        listModel = new ArrayListModel<E>(modelList);

        final MyJTable table = configureTable(clazz, viewContract, editorViewContractFactory);
        gui = new JPanel(new BorderLayout());
        gui.setFocusCycleRoot(true);
        gui.add(new JScrollPane(table));
    }

    private MyJTable configureTable(Class<E> clazz, ViewContract<E> viewContract,
                                    EditorViewContractFactory<E> editorViewContractFactory) {
        final MyJTable table = new MyJTable();
        table.getTableHeader().setVisible(false);
        table.setModel(new MyTableAdapter<E>(clazz, listModel));
        table.setDefaultRenderer(clazz, new AbstractObjectRenderer<E>(viewContract));
        table.setDefaultEditor(clazz, new ListViewRowEditor<E>(editorViewContractFactory));
        table.setRowHeight(50);
        //table.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.<AWTKeyStroke>emptySet());
        //table.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, Collections.<AWTKeyStroke>emptySet());
        //table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "none");
        //table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, InputEvent.SHIFT_DOWN_MASK), "none");
        table.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("Table focus gained");
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("Table focus lost");
            }
        });
        return table;
    }


    public List<E> getObjects() {
        return new ArrayList<E>(listModel);
    }

    public JComponent getGui() {
        return gui;
    }
}