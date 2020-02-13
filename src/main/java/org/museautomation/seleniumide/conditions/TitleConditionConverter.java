package org.museautomation.seleniumide.conditions;

import org.museautomation.core.values.*;
import org.museautomation.selenium.values.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused") // instantiated via reflection
public class TitleConditionConverter extends ConditionConverter
    {
    public TitleConditionConverter()
        {
        super("Title");
        }

    @Override
    public ValueSourceConfiguration createConditionSource(String param1, String param2)
        {
        ValueSourceConfiguration text_source = ValueSourceConfiguration.forType(PageTitleValueSource.TYPE_ID);
        return createTextMatchCondition(text_source, param1);
        }
    }


