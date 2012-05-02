package view;

import com.jgoodies.common.collect.ArrayListModel;

/**
 * Universitaire Ziekenhuizen Leuven
 * Date: 2/05/12
 */
public interface MyTableModelFactory<E> {

    MyTableAdapter<E> createModel(final ArrayListModel<E> objectList);
}
