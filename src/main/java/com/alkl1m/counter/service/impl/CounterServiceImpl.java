package com.alkl1m.counter.service.impl;

import com.alkl1m.counter.service.CounterService;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CounterServiceImpl implements CounterService {
    private final AtomicLong count = new AtomicLong(0);

    @Override
    public long increment() {
        return count.incrementAndGet();
    }

    @Override
    public void reset() {
        count.set(0);
    }

    @Override
    public long getCount() {
        return count.get();
    }

}
