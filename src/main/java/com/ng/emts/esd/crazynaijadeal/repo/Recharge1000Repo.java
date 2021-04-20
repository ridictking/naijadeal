package com.ng.emts.esd.crazynaijadeal.repo;

import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.Recharge1000;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Recharge1000Repo extends CrudRepository<Recharge1000,Long> {

    @Query(value = "Select * from RECHARGE_1k_ABOVE", nativeQuery = true)
    List<Recharge1000> getAll();
}
