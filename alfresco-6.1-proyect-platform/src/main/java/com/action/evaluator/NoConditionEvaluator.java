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

import java.util.List;

import org.alfresco.repo.action.evaluator.ActionConditionEvaluatorAbstractBase;
import org.alfresco.service.cmr.action.ActionCondition;
import org.alfresco.service.cmr.action.ParameterDefinition;
import org.alfresco.service.cmr.repository.NodeRef;

/**
 * No condition evaluator implementation.
 * 
 * @author Roy Wetherall
 */
public class NoConditionEvaluator extends ActionConditionEvaluatorAbstractBase
{
    /**
     * Evaluator constants
     */
    public static final String NAME = "no-condition";     
    
    /**
     * @see ActionConditionEvaluatorAbstractBase#evaluateImpl(ActionCondition, NodeRef)
     */
    public boolean evaluateImpl(ActionCondition ruleCondition, NodeRef actionedUponNodeRef)
    {
        return true;
    }

    /**
     * @see org.alfresco.repo.action.ParameterizedItemAbstractBase#addParameterDefinitions(List)
     */
    @Override
    protected void addParameterDefinitions(List<ParameterDefinition> paramList) 
    {
        // No parameters to add
    }
}
