package org.museautomation.seleniumide.steps;

import org.museautomation.seleniumide.*;
import org.museautomation.core.step.*;
import org.museautomation.core.values.*;
import org.museautomation.selenium.steps.*;
import org.museautomation.seleniumide.locators.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused")  // invoked via reflection from StepConverters
public class SelectFrameConverter implements StepConverter
    {
    @Override
    public StepConfiguration convertStep(String base_url, String command, String target, String value) throws UnsupportedError
        {
        if (command.equals(SELECT_FRAME))
            {
            if (target.startsWith(INDEX_PREFIX))
                {
                try
                    {
                    int index = Integer.parseInt(target.substring(INDEX_PREFIX.length()));
                    StepConfiguration step = new StepConfiguration(SwitchTo.TYPE_ID);
                    step.addSource(SwitchTo.TARGET_PARAM, ValueSourceConfiguration.forValue(index));
                    return step;
                    }
                catch (NumberFormatException e)
                    {
                    throw new UnsupportedError("unexpected index in selectFrame command: " + target);
                    }
                }
            else if (target.startsWith(RELATIVE_PREFIX))
                {
                String relative = target.substring(RELATIVE_PREFIX.length());
                switch (relative)
                    {
                    case RELATIVE_TOP:
                        return new StepConfiguration(SwitchToTopFrame.TYPE_ID);
                    case RELATIVE_PARENT:
                        return new StepConfiguration(SwitchToParentFrame.TYPE_ID);
                    }
                }
            else
                {
                StepConfiguration step = new StepConfiguration(SwitchTo.TYPE_ID);
                step.addSource(SwitchTo.TARGET_PARAM, LocatorConverters.get().convert(target));
                return step;
                }
            }
        return null;
        }

    public static final String SELECT_FRAME = "selectFrame";
    public static final String INDEX_PREFIX = "index=";
    public static final String RELATIVE_PREFIX = "relative=";
    public static final String RELATIVE_TOP = "top";
    public static final String RELATIVE_PARENT = "parent";
    }