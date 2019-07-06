package com.queue;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.queue.Metric;
import com.queue.MetricsService;

@RestController
public class MetricsController {

    @Autowired
    private MetricsService metricService;

    @GetMapping(path = "/metric")
    public List<Metric> getAll() {
        return metricService.getAll();
    }

    @GetMapping(path = "/metric/{id}")
    public Metric getById(@PathVariable("id") UUID id) {
        return metricService.get(id);
    }

    @PostMapping(path = "/metric")
    public Metric create(@RequestBody Metric metric) {
        return metricService.create(metric);
    }

    @DeleteMapping(path = "/metric/{id}")
    public void delete(@PathVariable("id") UUID id) {
        metricService.delete(id);
    }
}
