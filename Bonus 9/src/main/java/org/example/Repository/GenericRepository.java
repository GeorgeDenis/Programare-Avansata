package org.example.Repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T> {
    void create(T entity) throws SQLException;
    T findById(int id);
    List<T> findByName(String name);
}
