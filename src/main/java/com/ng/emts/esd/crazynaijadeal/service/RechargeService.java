package com.ng.emts.esd.crazynaijadeal.service;

import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.Recharge1000;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.Recharge700;
import com.ng.emts.esd.crazynaijadeal.repo.Recharge1000Repo;
import com.ng.emts.esd.crazynaijadeal.repo.Recharge700Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RechargeService {
    private final Recharge700Repo recharge700Repo;
    private final Recharge1000Repo recharge1000Repo;

    @Autowired
    public RechargeService(Recharge700Repo recharge700Repo, Recharge1000Repo recharge1000Repo) {
        this.recharge700Repo = recharge700Repo;
        this.recharge1000Repo = recharge1000Repo;
    }

    public List<Recharge1000> getRecharge1000andAbove(){
        List<Recharge1000> allMsisdn = new ArrayList<>();
        Iterable<Recharge1000> all = recharge1000Repo.findAll();
        all.forEach(allMsisdn::add);
        return allMsisdn;
    }

    public List<Recharge1000> getAll(){
        List<Recharge1000> all = recharge1000Repo.getAll();
               return all.stream()
                       .filter(x-> x.getRefDate().equals(LocalDate.now()))
                       .collect(Collectors.toList());
    }

    public List<Recharge700> getRecharge700(){
        List<Recharge700> allMsisdn = new ArrayList<>();
        Iterable<Recharge700> all = recharge700Repo.findAll();
        all.forEach(allMsisdn::add);
        return allMsisdn;
    }
}
