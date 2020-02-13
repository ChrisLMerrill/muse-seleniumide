package org.museautomation.seleniumide;

import org.museautomation.core.values.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
public interface LocatorConverter
    {
    ValueSourceConfiguration createLocator(String parameter);
    }


