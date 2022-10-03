package com.jdnegrido.exam;

import org.springframework.data.repository.CrudRepository;

import com.jdnegrido.exam.Number;

public interface NumberRepository extends CrudRepository<Number, Integer> {
    public Iterable<Number> findAllByOrderByIdDesc();
}