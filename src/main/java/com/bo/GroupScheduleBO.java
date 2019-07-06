package com.bo;

import com.model.*;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class GroupScheduleBO
{

    @Autowired
    private GroupScheduleRepository repository;

    public GroupSchedule getByCode(Long id) throws EntityNotFoundException
    {
        return this.repository.getOne(id);
    }

    public List<GroupSchedule> findAll()
    {
        return repository.findAll();
    }
}