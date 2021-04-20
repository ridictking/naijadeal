package com.ng.emts.esd.crazynaijadeal.service;


import com.ng.emts.esd.crazynaijadeal.exceptions.NotFoundException;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.ValueConfig;
import com.ng.emts.esd.crazynaijadeal.repo.ValueConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValueConfigService {
    private final ValueConfigRepo repo;

    @Autowired
    public ValueConfigService(ValueConfigRepo repo) {
        this.repo = repo;
    }

    public void addConfig(ValueConfig config){
        Optional<ValueConfig> byConfigName = repo.findByConfigName(config.getConfigName());
        byConfigName.ifPresent(valueConfig -> repo.deleteById(valueConfig.getId()));
        repo.save(config);
    }

    public List<ValueConfig> valueConfigs(){
        return repo.findAll();
    }
    public ValueConfig getConfigByName(String configName){
        Optional<ValueConfig> byConfigName = repo.findByConfigName(configName);
        if(byConfigName.isPresent()) return byConfigName.get();
        else throw new NotFoundException("Config name "+ configName + " does not exist");
    }
}
