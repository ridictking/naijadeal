package com.ng.emts.esd.crazynaijadeal.repo;

import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.CrazyNaijaDealRequest;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.CrazyNaijaRequestLog;
import org.springframework.data.repository.CrudRepository;

public interface CrazyNaijaDealRepo extends CrudRepository<CrazyNaijaDealRequest, Long> {
}
