package org.museautomation.seleniumide.conditions;

import org.museautomation.seleniumide.*;
import org.museautomation.core.values.*;
import org.museautomation.selenium.values.*;
import org.museautomation.seleniumide.locators.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused") // instantiated via reflection
public class TextConditionConverter extends ConditionConverter
    {
    public TextConditionConverter()
        {
        super("Text");
        }

    @Override
    public ValueSourceConfiguration createConditionSource(String param1, String param2) throws UnsupportedError
        {
        ValueSourceConfiguration text_source = ValueSourceConfiguration.forTypeWithSource(ElementTextSource.TYPE_ID, LocatorConverters.get().convert(param1));
        return createTextMatchCondition(text_source, param2);
        }
    }


