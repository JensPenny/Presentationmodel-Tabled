package carexample.view;

import com.jgoodies.binding.adapter.ComboBoxAdapter;
import carexample.model.Car;
import view.ViewContract;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: jpenny0
 * Date: 30/04/12
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
public class SingleCarRowViewer implements ViewContract<Car> {
    private JPanel mainPanel;
    private JLabel txtName;
    private JLabel txtWielen;
    private JLabel txtDeuren;
    private JComboBox cmbTypes;

    private final CarPM carPM;

    public SingleCarRowViewer(Car model) {
        this.carPM = new CarPM(model);
    }
    public void setDataOnce(){
        txtName.setText(carPM.getNameValueModel().getValue().toString());
        txtDeuren.setText(carPM.getDoorValueModel().getValue().toString());
        txtWielen.setText(carPM.getWheelValueModel().getValue().toString());
        ComboBoxAdapter adapter = new ComboBoxAdapter((ListModel)carPM.getPossibleTypeListModel(), carPM.getSelectedTypeHolder());
        cmbTypes.setModel(adapter);
    }

    private Car getCar() {
        return carPM.getCar();
    }

    @Override
    public Car getModel() {
        return carPM.getBean();
    }

    @Override
    public void setModel(Car model) {
        carPM.setBean(model);
    }

    public JComponent getGui() {
        return mainPanel;
    }

    @Override
    public void setBindings() {

    }
}
