package org.museautomation.seleniumide.steps;

import org.museautomation.seleniumide.*;
import org.museautomation.core.step.*;
import org.museautomation.selenium.steps.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
@SuppressWarnings("unused")  // invoked via reflection from StepConverters
public class NavigateConverter implements StepConverter
    {
    @Override
    public StepConfiguration convertStep(String base_url, String command, String param1, String param2) throws UnsupportedError
        {
        if (command.equals(BACK) || command.equals(BACK_AND_WAIT))
            return new StepConfiguration(NavigateBack.TYPE_ID);
        if (command.equals(REFRESH) || command.equals(REFRESH_AND_WAIT))
            return new StepConfiguration(RefreshPage.TYPE_ID);
        return null;
        }

    private static final String BACK = "goBack";
    private static final String BACK_AND_WAIT = "goBackAndWait";
    private static final String REFRESH = "refresh";
    private static final String REFRESH_AND_WAIT = "refreshAndWait";
    // note: there is apparently no forward implemented in the IDE
    }


