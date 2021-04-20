package com.ng.emts.esd.crazynaijadeal.repo;

import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.GiftAccessCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface GiftAccessCodeRepo extends JpaRepository<GiftAccessCode, Long> {
    @Query(value = "update regular_coupons\n" +
            "set used = 1 where used = 0", nativeQuery = true)
    void reset();

    Optional<GiftAccessCode> findByGiftCode(String code);
    List<GiftAccessCode> findByMsisdnIsNotNullAndUsedFalse();
    List<GiftAccessCode> findByUsedFalseAndMsisdnIsNull();
    List<GiftAccessCode> findByUsedFalseAndExpiredFalseAndGiftCodeExpiryBefore(LocalDateTime now);
    List<GiftAccessCode> findByMsisdnIsNullAndCrazyGiftCodeIsNull();
    List<GiftAccessCode> findByExpiredTrue();
    List<GiftAccessCode> findByExpiredFalse();

    List<GiftAccessCode> findByUsedFalseAndExpiredFalseAndMsisdnIsNotNull();
}
