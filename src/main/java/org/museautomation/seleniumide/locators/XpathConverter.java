package org.museautomation.seleniumide.locators;

import org.museautomation.seleniumide.*;
import org.museautomation.core.values.*;
import org.museautomation.selenium.locators.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused")  // used via reflection by LocatorConverters
public class XpathConverter implements LocatorConverter
    {
    @Override
    public ValueSourceConfiguration createLocator(String parameter)
        {
        if (parameter.startsWith(PREFIX))
            return ValueSourceConfiguration.forTypeWithSource(XPathElementValueSource.TYPE_ID, parameter.substring(PREFIX.length()));
        else if (parameter.startsWith("//"))
            return ValueSourceConfiguration.forTypeWithSource(XPathElementValueSource.TYPE_ID, parameter);
        return null;
        }

    private final static String PREFIX = "xpath=";
    }


