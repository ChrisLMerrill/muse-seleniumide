package org.museautomation.seleniumide.steps;

import org.museautomation.seleniumide.*;
import org.museautomation.builtins.step.*;
import org.museautomation.builtins.value.logic.*;
import org.museautomation.core.step.*;
import org.museautomation.core.values.*;
import org.museautomation.selenium.conditions.*;
import org.museautomation.selenium.steps.*;
import org.museautomation.seleniumide.locators.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused")  // invoked via reflection from StepConverters
public class CheckboxConverter implements StepConverter
    {
    @Override
    public StepConfiguration convertStep(String base_url, String command, String param1, String param2) throws UnsupportedError
        {
        if (command.equals(CHECK) || command.equals(UNCHECK))
            {
            boolean check = true;
            if (command.equals(UNCHECK))
                check = false;

            StepConfiguration click = new StepConfiguration(ClickElement.TYPE_ID);
            click.addSource(ClickElement.ELEMENT_PARAM, LocatorConverters.get().convert(param1));

            ValueSourceConfiguration condition = ValueSourceConfiguration.forType(ElementSelectedCondition.TYPE_ID);
            condition.setSource(LocatorConverters.get().convert(param1));
            if (check)
                condition = ValueSourceConfiguration.forTypeWithSource(NotValueSource.TYPE_ID, condition);

            StepConfiguration if_step = new StepConfiguration(IfStep.TYPE_ID);
            if_step.addSource(IfStep.CONDITION_PARAM, condition);

            StepConfiguration click_step = new StepConfiguration(ClickElement.TYPE_ID);
            click_step.addSource(ClickElement.ELEMENT_PARAM, LocatorConverters.get().convert(param1));
            if_step.addChild(click_step);

            return if_step;
            }
        return null;
        }

    public static final String CHECK = "check";
    public static final String UNCHECK = "uncheck";
    }


