package view;

import java.awt.*;

/**
* Universitaire Ziekenhuizen Leuven
* Date: 3/05/12
*/
public interface EditorViewContract<E> extends ViewContract<E> {

    boolean isLastComponentInView(Component aComponent);

    void requestFocus();
}
