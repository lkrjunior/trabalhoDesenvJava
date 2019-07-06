package com.bo;

import com.model.*;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalTime;
import java.util.List;

@Component
public class GroupBO
{

    @Autowired
    private GroupRepository repository;

    public Group getByCode(Long id) throws EntityNotFoundException
    {
        return this.repository.getOne(id);
    }

    public List<Group> findAll()
    {
        return repository.findAll();
    }

    public Group findDefaultAlert()
    {
        return repository.findDefaultAlert();
    }

    public Group findAlert(String metric, LocalTime time)
    {
        return repository.findAlert(metric, time);
    }
}