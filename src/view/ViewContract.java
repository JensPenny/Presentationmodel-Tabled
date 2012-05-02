package view;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public interface ViewContract <E> {
    public JComponent getGui();
    public void setBindings();
    public void setDataOnce();
    public E getModel();
    public void setModel(E model);
}
