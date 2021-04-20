package com.ng.emts.esd.crazynaijadeal.repo;

import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.ValueConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValueConfigRepo extends JpaRepository<ValueConfig,Integer> {
    Optional<ValueConfig> findByConfigName(String configName);
}
