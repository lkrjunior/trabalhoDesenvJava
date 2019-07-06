package com.bo;

import com.model.Group;
import com.repository.GroupRepository;
import com.bo.GroupBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class GroupBOTest
{
    private final String _metric_cpu = "CPU".toLowerCase();
    private final String _metric_memory = "MEMORY".toLowerCase();

    @Autowired
    private GroupBO groupBO;

    private GroupRepository repository;

    private LocalTime GetLocalTimeByHour(int hour)
    {
        return LocalTime.of(hour, 00, 00, 00000);
    }

    private Group GetGroupByMetricAndTime(String metric, LocalTime localTime)
    {
        return groupBO.findAlert(metric, localTime);
    }

    @Test
    public void getAlertDefault()
    {
        Group group = groupBO.findDefaultAlert();
        assertNotNull(group);
        assertTrue(group.GetEmail() != null);
        assertTrue(group.GetSlackWebook() != null);
        assertTrue(group.GetSlackEndpoint() != null);
    }

    @Test
    public void getAlertByMetricAndTimeCPU()
    {
        Group group = GetGroupByMetricAndTime(_metric_cpu, GetLocalTimeByHour(1));
        assertNotNull(group);
        assertTrue(group.GetEmail() != null);
        assertTrue(group.GetSlackWebook() != null);
        assertTrue(group.GetSlackEndpoint() != null);

        group = GetGroupByMetricAndTime(_metric_cpu, GetLocalTimeByHour(9));
        assertNotNull(group);
        assertTrue(group.GetEmail() != null);
        assertTrue(group.GetSlackWebook() != null);
        assertTrue(group.GetSlackEndpoint() != null);

        group = GetGroupByMetricAndTime(_metric_cpu, GetLocalTimeByHour(20));
        assertNotNull(group);
        assertTrue(group.GetEmail() != null);
        assertTrue(group.GetSlackWebook() != null);
        assertTrue(group.GetSlackEndpoint() != null);

    }

    @Test
    public void getAlertByMetricAndTimeMemory()
    {
        Group group = GetGroupByMetricAndTime(_metric_memory, GetLocalTimeByHour(1));
        assertNotNull(group);
        assertTrue(group.GetEmail() != null);
        assertTrue(group.GetSlackWebook() != null);
        assertTrue(group.GetSlackEndpoint() != null);

        group = GetGroupByMetricAndTime(_metric_memory, GetLocalTimeByHour(9));
        assertNotNull(group);
        assertTrue(group.GetEmail() != null);
        assertTrue(group.GetSlackWebook() != null);
        assertTrue(group.GetSlackEndpoint() != null);

        group = GetGroupByMetricAndTime(_metric_memory, GetLocalTimeByHour(20));
        assertNotNull(group);
        assertTrue(group.GetEmail() != null);
        assertTrue(group.GetSlackWebook() != null);
        assertTrue(group.GetSlackEndpoint() != null);
    }
}
