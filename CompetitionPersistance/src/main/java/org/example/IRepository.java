package org.example;


import java.io.Serializable;

public interface IRepository<ID extends Serializable, E extends GenericEntity<ID>> {
    E findOne(ID id);
    Iterable<E> findAll();
    E save(E entityForAdd);
}
