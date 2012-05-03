package view;

/**
 * Created by Pieter Laeremans - 05/2012
 */
public interface EditorViewContractFactory<E> {
    EditorViewContract<E> create(E e);
}
