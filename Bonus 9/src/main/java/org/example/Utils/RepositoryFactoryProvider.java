package org.example.Utils;

import org.example.Repository.RepositoryFactory;
import org.example.Utils.JdbcRepositoryFactory;
import org.example.Utils.JpaRepositoryFactory;

public class RepositoryFactoryProvider {
    public static RepositoryFactory getFactory(String type) {
        if (type.equals("jdbc")) {
            return new JdbcRepositoryFactory();
        } else if (type.equals("jpa")) {
            return new JpaRepositoryFactory();
        }
        throw new IllegalArgumentException("Invalid type");
    }
}
