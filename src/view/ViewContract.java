package view;

import model.CarPM;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public interface ViewContract {
    public JComponent getGui();
    public void setBindings();
    public void setDataOnce();
    public CarPM getPresentationModel();
    public void setPresentationModel(CarPM model);
}
