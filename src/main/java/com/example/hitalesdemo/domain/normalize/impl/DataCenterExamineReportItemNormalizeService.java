package com.example.hitalesdemo.domain.normalize.impl;

import com.example.hitalesdemo.domain.normalize.INormalizeService;
import com.example.hitalesdemo.domain.normalize.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class DataCenterExamineReportItemNormalizeService implements INormalizeService<Person> {
    @Override
    public List<Person> normalize(Person person) {
        log.info("调用的是examine");
        return Collections.singletonList(person);
    }
}
