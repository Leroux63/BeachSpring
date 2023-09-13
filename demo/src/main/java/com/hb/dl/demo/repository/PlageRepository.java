package com.hb.dl.demo.repository;

import com.hb.dl.demo.models.Plage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface PlageRepository extends CrudRepository<Plage,Long> {

    @Override
    List<Plage> findAll();

    List<Plage> findByName(String name);

    @Query(value = "FROM Plage p ORDER BY p.name asc")
    Page<Plage> pagePagination(Pageable page);


}
