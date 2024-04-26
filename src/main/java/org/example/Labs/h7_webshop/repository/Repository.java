package org.example.Labs.h7_webshop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public abstract class Repository {
    final EntityManager em;

    Repository(EntityManager em) {
        this.em = em;
    }

    public <T> void PerformTransActionConsumer(Consumer<T> anEntityManagerAction, T subject) {
        performTransaction(x -> {
            anEntityManagerAction.accept(x);
            return x;
        }, subject);
    }

    public <T> T performTransaction(Function<T, T> anEntityManagerAction, T subject) {
        EntityTransaction transaction = em.getTransaction();
        T result = null;
        try {
            transaction.begin();
            result = anEntityManagerAction.apply(subject);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            log.error(ex.getMessage(), ex);
        }
        return result;
    }
}
