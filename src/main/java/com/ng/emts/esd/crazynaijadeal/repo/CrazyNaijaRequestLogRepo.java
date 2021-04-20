package com.ng.emts.esd.crazynaijadeal.repo;


import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.CrazyNaijaRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface CrazyNaijaRequestLogRepo extends JpaRepository<CrazyNaijaRequestLog, Long> {
    CrazyNaijaRequestLog findByRequestInTimeAndMsisdn(LocalDateTime requestTimeIn, String msisdn);
}
