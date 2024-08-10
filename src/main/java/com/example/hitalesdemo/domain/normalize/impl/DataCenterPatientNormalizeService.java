package com.example.hitalesdemo.domain.normalize.impl;

import com.example.hitalesdemo.domain.normalize.INormalizeService;
import com.example.hitalesdemo.domain.normalize.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class DataCenterPatientNormalizeService implements INormalizeService<User> {
    @Override
    public List<User> normalize(User user) {
        log.info("调用的是patient");
        return Collections.singletonList(user);
    }
}
