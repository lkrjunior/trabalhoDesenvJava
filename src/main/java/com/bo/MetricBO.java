package com.bo;

import com.model.*;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class MetricBO
{

    @Autowired
    private MetricRepository metricRepository;

    public Metric getByCode(Long id) throws EntityNotFoundException
    {
        return this.metricRepository.getOne(id);
    }

    public List<Metric> findAll()
    {
        return metricRepository.findAll();
    }

    public Metric findMetricByCode(String code)
    {
        return metricRepository.findMetricByCode(code);
    }
}
