package iuh.fit.se.tuan4.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory entityManageFactory;
    static {
        try {
            entityManageFactory = Persistence.createEntityManagerFactory("news-management");
        } catch (Throwable ex) {
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static EntityManager getEntityManager() {
        return entityManageFactory.createEntityManager();
    }
    public static void close() {
        if (entityManageFactory.isOpen()) {
            entityManageFactory.close();
        }
    }
}
