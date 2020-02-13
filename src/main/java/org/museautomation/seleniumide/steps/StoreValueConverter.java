package org.museautomation.seleniumide.steps;

import org.museautomation.seleniumide.*;
import org.museautomation.builtins.step.*;
import org.museautomation.core.step.*;
import org.museautomation.seleniumide.values.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused")  // invoked via reflection from StepConverters
public class StoreValueConverter implements StepConverter
    {
    @Override
    public StepConfiguration convertStep(String base_url, String command, String param1, String param2) throws UnsupportedError
        {
        if (!STORE.equals(command))
            return null;
        StepConfiguration step = new StepConfiguration(StoreVariable.TYPE_ID);
        step.addSource(StoreVariable.NAME_PARAM, ValueConverters.get().convert(param1));
        step.addSource(StoreVariable.VALUE_PARAM, ValueConverters.get().convert(param2));
        return step;
        }

    public final static String STORE = "store";
    }


