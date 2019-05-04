package app.services;

import java.util.List;

public interface CrudService<T> {
    void create(T object);
    T read(Integer id);
    void update(T object);
    void delete(T object);
    List<T> list();
}
