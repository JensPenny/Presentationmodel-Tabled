package view;

import view.impl.EditableListViewImpl;

import javax.swing.*;
import java.util.List;

/**
 * Created by Pieter Laeremans - 05/2012
 */
public class EditableListView<E> {
    private final EditableListViewImpl<E> impl;

    public EditableListView(final Class<E> clazz, final List<E> modelList,
                            final ViewContract<E> viewContract,
                            final EditorViewContractFactory<E> editorViewContractFactory) {
        impl = new EditableListViewImpl<E>(clazz, modelList, viewContract, editorViewContractFactory);
    }

    public List<E> getObjects() {
        return impl.getObjects();
    }


    public JComponent getGui() {
        return impl.getGui();
    }
}
