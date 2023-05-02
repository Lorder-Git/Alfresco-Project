/*
 * #%L
 * Alfresco Repository
 * %%
 * Copyright (C) 2005 - 2016 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package com.action;

import org.alfresco.error.AlfrescoRuntimeException;
import org.alfresco.repo.action.executer.MailActionExecuter;
import org.springframework.extensions.surf.util.I18NUtil;

public class MailActionExecuterMonitor
{
    private org.alfresco.repo.action.executer.MailActionExecuter mailActionExceuter;
    
    public String sendTestMessage()
    {
        try
        {
            mailActionExceuter.sendTestMessage();
            Object[] params = {mailActionExceuter.getTestMessageTo()};
            String message = I18NUtil.getMessage("email.outbound.test.send.success", params);
            return message;
        }
        catch (AlfrescoRuntimeException are)
        {
            return (are.getMessage());
        }
    }
    public int getNumberFailedSends()
    {
        return mailActionExceuter.getNumberFailedSends();
    }
    
    public int getNumberSuccessfulSends()
    {
        return mailActionExceuter.getNumberSuccessfulSends();
    }
    
    public void setMailActionExecuter(MailActionExecuter mailActionExceuter)
    {
        this.mailActionExceuter = mailActionExceuter;
    }
}
