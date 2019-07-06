package com.bo;

import com.contracts.INotification;
import com.model.Group;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AlertSlackBO implements INotification
{
    private static final Logger logger = LoggerFactory.getLogger(AlertSlackBO.class);

    private final String _channel = "#alerta_gerado";

    @Override
    public Boolean Send(RulesBO rulesBO)
    {
        try
        {
            Group group = rulesBO.GetGroupForAlert();
            SlackApi api = new SlackApi(group.GetSlackWebook());
            api.call(new SlackMessage(_channel, null, rulesBO.GetMessage()));
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }

        return true;
    }
}
