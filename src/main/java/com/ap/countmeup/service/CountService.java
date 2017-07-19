package com.ap.countmeup.service;

import com.ap.countmeup.dto.CountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CountService {
    private Environment env;

    @Autowired
    public CountService(Environment env) {
        this.env = env;
    }

    public CountResponse getCount() {

        return null;
    }
}
