package com.ng.emts.esd.crazynaijadeal.repo;

import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.CrazyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CrazyCodeRepo extends JpaRepository<CrazyCode, Long> {
    @Query(value = "update regular_coupons\n" +
            "set used = 0 where used = 1", nativeQuery = true)
    void reset();

    Optional<CrazyCode> findByCrazyCode(String crazyCode);
}
