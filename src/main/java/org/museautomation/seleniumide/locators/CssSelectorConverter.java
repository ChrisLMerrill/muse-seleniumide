package org.museautomation.seleniumide.locators;

import org.museautomation.seleniumide.*;
import org.museautomation.core.values.*;
import org.museautomation.selenium.locators.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused")  // used via reflection by LocatorConverters
public class CssSelectorConverter implements LocatorConverter
    {
    @Override
    public ValueSourceConfiguration createLocator(String parameter)
        {
        if (parameter.startsWith(PREFIX))
            return ValueSourceConfiguration.forTypeWithSource(CssElementValueSource.TYPE_ID, parameter.substring(PREFIX.length()));
        return null;
        }

    private final static String PREFIX = "css=";
    }


