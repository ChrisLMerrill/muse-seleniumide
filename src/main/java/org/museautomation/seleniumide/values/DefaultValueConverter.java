package org.museautomation.seleniumide.values;

import org.museautomation.seleniumide.*;
import org.museautomation.core.values.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
class DefaultValueConverter implements ValueConverter
    {
    @Override
    public ValueSourceConfiguration convert(String parameter)
        {
        return ValueSourceConfiguration.forValue(parameter);
        }
    }


