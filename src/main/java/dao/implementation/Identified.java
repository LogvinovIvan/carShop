package dao.implementation;

import java.io.Serializable;

/**
 * Created by Иван on 08.04.2016.
 */
public interface Identified<PK extends Serializable> {

    /** Возвращает идентификатор объекта */
    public PK getId();
}
