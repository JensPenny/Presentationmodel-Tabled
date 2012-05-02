package view;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Universitaire Ziekenhuizen Leuven
 * Date: 2/05/12
 */
public class AbstractObjectRenderer<E> implements TableCellRenderer {
    private final ViewContract<E> viewContract;

    public AbstractObjectRenderer(final ViewContract<E> viewContract) {
        this.viewContract = viewContract;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, final int row, final int column) {
        E model = (E) value;
        viewContract.setModel(model);
        viewContract.getGui().getPreferredSize();
        return viewContract.getGui();
    }
}
