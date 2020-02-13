package org.museautomation.seleniumide.steps;

import org.museautomation.seleniumide.*;
import org.museautomation.core.step.*;
import org.museautomation.selenium.steps.*;
import org.museautomation.seleniumide.locators.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused")  // invoked via reflection from StepConverters
public class ClickConverter implements StepConverter
    {
    @Override
    public StepConfiguration convertStep(String base_url, String command, String param1, String param2) throws UnsupportedError
        {
        if (command.equals(CLICK) || command.equals(CLICK_AND_WAIT) || command.equals(CLICK_AT))
            {
            StepConfiguration step = new StepConfiguration(ClickElement.TYPE_ID);
            step.addSource(ClickElement.ELEMENT_PARAM, LocatorConverters.get().convert(param1));
            return step;
            }
        return null;
        }

    public static final String CLICK = "click";
    private static final String CLICK_AND_WAIT = "clickAndWait";
    private static final String CLICK_AT = "clickAt";
    }


