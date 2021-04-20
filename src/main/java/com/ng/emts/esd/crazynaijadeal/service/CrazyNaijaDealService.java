package com.ng.emts.esd.crazynaijadeal.service;

import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.CrazyCode;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.CrazyNaijaRequestLog;
import com.ng.emts.esd.crazynaijadeal.model.request.IPCCRequestBody;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.GiftAccessCode;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface CrazyNaijaDealService {
    void redeemCode(IPCCRequestBody request, CrazyNaijaRequestLog crazyNaijaRequestLog);

    @Scheduled(cron = "0 15 * * * *")
    void doGiftingOfAccessCodes();

    void doSevenHundredSms();

    void reAssignCrazy();
    void setDefault();
    List<GiftAccessCode> doCrazyCodeAssign();
}
