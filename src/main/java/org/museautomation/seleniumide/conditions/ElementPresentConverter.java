package org.museautomation.seleniumide.conditions;

import org.museautomation.seleniumide.*;
import org.museautomation.core.values.*;
import org.museautomation.selenium.conditions.*;
import org.museautomation.seleniumide.locators.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused") // instantiated via reflection
public class ElementPresentConverter extends ConditionConverter
    {
    public ElementPresentConverter()
        {
        super("ElementPresent");
        }

    @Override
    public ValueSourceConfiguration createConditionSource(String param1, String param2) throws UnsupportedError
        {
        return ValueSourceConfiguration.forTypeWithSource(ElementExistsCondition.TYPE_ID, LocatorConverters.get().convert(param1));
        }
    }


