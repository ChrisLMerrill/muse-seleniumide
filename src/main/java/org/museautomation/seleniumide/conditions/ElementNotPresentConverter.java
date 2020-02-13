package org.museautomation.seleniumide.conditions;

import org.museautomation.seleniumide.*;
import org.museautomation.builtins.value.logic.*;
import org.museautomation.core.values.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused") // instantiated via reflection
public class ElementNotPresentConverter extends ConditionConverter
    {
    public ElementNotPresentConverter()
        {
        super("ElementNotPresent");
        }

    @Override
    public ValueSourceConfiguration createConditionSource(String param1, String param2) throws UnsupportedError
        {
        return ValueSourceConfiguration.forTypeWithSource(NotValueSource.TYPE_ID, new ElementPresentConverter().createConditionSource(param1, param2));
        }
    }


