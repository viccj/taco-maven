package com.lazyvic.data;

import com.lazyvic.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository  extends PagingAndSortingRepository<Taco, Long> {
    void save(Taco taco2);
}
