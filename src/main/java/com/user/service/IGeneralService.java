package com.user.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    T save(T t);

    boolean delete(Long id);

    Optional<T> findById(Long id);

}
