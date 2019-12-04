package org.musetest.seleniumide;

import org.musetest.core.step.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
public interface StepConverter
    {
    StepConfiguration convertStep(String base_url, String command, String target, String value) throws UnsupportedError;
    }

