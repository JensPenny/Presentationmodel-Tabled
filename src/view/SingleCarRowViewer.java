package view;

import com.jgoodies.binding.adapter.ComboBoxAdapter;
import model.CarPM;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
public class SingleCarRowViewer implements ViewContract{
    private JPanel mainPanel;
    private JLabel txtName;
    private JLabel txtWielen;
    private JLabel txtDeuren;
    private JComboBox cmbTypes;

    private CarPM presentationModel;

    public SingleCarRowViewer(CarPM model)
    {
        this.presentationModel = model;
    }
    public void setDataOnce(){
        txtName.setText(presentationModel.getNameValueModel().getValue().toString());
        txtDeuren.setText(presentationModel.getDoorValueModel().getValue().toString());
        txtWielen.setText(presentationModel.getWheelValueModel().getValue().toString());
        ComboBoxAdapter adapter = new ComboBoxAdapter((ListModel)presentationModel.getPossibleTypeListModel(), presentationModel.getSelectedTypeHolder());
        cmbTypes.setModel(adapter);
    }

    public JComponent getGui() {
        return mainPanel;
    }

    @Override
    public void setBindings() {

    }

    @Override
    public CarPM getPresentationModel() {
        return this.presentationModel;
    }

    @Override
    public void setPresentationModel(CarPM model){
        this.presentationModel = model;
    }
}
