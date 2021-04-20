package com.ng.emts.esd.crazynaijadeal.repo;

import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.Recharge700;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface Recharge700Repo extends CrudRepository<Recharge700,Long> {

    @Query(value = "Select * from RECHARGE_700", nativeQuery = true)
    Collection<?> listRecharge700();
}
