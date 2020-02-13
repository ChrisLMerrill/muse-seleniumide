package org.museautomation.seleniumide.steps;

import org.museautomation.seleniumide.*;
import org.museautomation.core.step.*;
import org.museautomation.core.values.*;
import org.museautomation.selenium.steps.*;
import org.museautomation.seleniumide.locators.*;
import org.museautomation.seleniumide.values.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused")  // invoked via reflection from StepConverters
public class SendKeysConverter implements StepConverter
    {
    @Override
    public StepConfiguration convertStep(String base_url, String command, String param1, String param2) throws UnsupportedError
        {
        if (!TYPE.equals(command) && !SENDKEYS.equals(command))
            return null;
        StepConfiguration step = new StepConfiguration(SendKeys.TYPE_ID);
        step.addSource(SendKeys.ELEMENT_PARAM, LocatorConverters.get().convert(param1));
        step.addSource(SendKeys.KEYS_PARAM, ValueConverters.get().convert(param2));
        if (TYPE.equals(command))
            step.addSource(SendKeys.CLEAR_PARAM, ValueSourceConfiguration.forValue(true));
        return step;
        }

    private final static String TYPE = "type";
    private final static String SENDKEYS = "sendKeys";
    }


