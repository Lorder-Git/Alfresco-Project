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

import org.alfresco.repo.action.RuntimeActionService;
import org.alfresco.repo.transaction.TransactionListener;
import org.alfresco.util.GUID;

/**
 * The action service transaction listener
 * 
 * @author Roy Wetherall
 */
public class ActionTransactionListener implements TransactionListener
{
    /**
     * Id used in equals and hash
     */
    private String id = GUID.generate();
    
    /**
     * The action service (runtime interface)
     */
    private org.alfresco.repo.action.RuntimeActionService actionService;
    
    /**
     * Constructor
     * 
     * @param actionService        the action service
     */
    public ActionTransactionListener(RuntimeActionService actionService)
    {
        this.actionService = actionService;
    }
    
    /**
     * @see TransactionListener#flush()
     */
    public void flush()
    {
    }

    /**
     * @see TransactionListener#beforeCommit(boolean)
     */
    public void beforeCommit(boolean readOnly)
    {
    }

    /**
     * @see TransactionListener#beforeCompletion()
     */
    public void beforeCompletion()
    {
    }

    /**
     * @see TransactionListener#afterCommit()
     */
    public void afterCommit()
    {
        this.actionService.postCommit();
    }

    /**
     * @see TransactionListener#afterRollback()
     */
    public void afterRollback()
    {
    }
    
    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return this.id.hashCode();
    }
    
    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj instanceof ActionTransactionListener)
        {
            ActionTransactionListener that = (ActionTransactionListener) obj;
            return (this.id.equals(that.id));
        }
        else
        {
            return false;
        }
    }

}
