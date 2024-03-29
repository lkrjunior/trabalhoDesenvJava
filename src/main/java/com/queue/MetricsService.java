package com.queue;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.queue.Metric;

@Service
public class MetricsService {

    public List<Metric> getAll() {
        return Arrays.asList(new Metric("hello", 1L), new Metric("world", 2L));
    }

    public Metric get(UUID id) {
        System.out.println("id: " + id);
        return new Metric(id, "test", 3L);
    }

    public Metric create(Metric metric) {
        // TODO Auto-generated method stub
        return null;
    }

    public void delete(UUID id) {
        // TODO Auto-generated method stub

    }

}
