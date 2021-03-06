package org.museautomation.seleniumide.steps;

import org.museautomation.seleniumide.*;
import org.museautomation.core.step.*;
import org.reflections.*;
import org.slf4j.*;

import java.util.*;

/**
 * @author Christopher L Merrill (see LICENSE.txt for license details)
 */
public class StepConverters implements StepConverter
    {
    public static StepConverters get()
        {
        if (INSTANCE == null)
            INSTANCE = new StepConverters();
        return INSTANCE;
        }

    @Override
    public StepConfiguration convertStep(String base_url, String command, String target, String value) throws UnsupportedError
        {
        for (StepConverter converter : _converters)
            {
            StepConfiguration step = converter.convertStep(base_url, command, target, value);
            if (step != null)
                return step;
            }
        throw new UnsupportedError(String.format("Unknown command: %s (%s, %s)", command, target, value));
        }

    private StepConverters()
        {
        Reflections reflections = new Reflections("org.museautomation.seleniumide.steps");
        Set<Class<? extends StepConverter>> converter_classes = reflections.getSubTypesOf(StepConverter.class);
        for (Class<? extends StepConverter> converter_class : converter_classes)
            try
                {
                if (converter_class != getClass())
                    _converters.add(converter_class.newInstance());
                }
            catch (Exception e)
                {
                LOG.error(String.format("Unable to instantiate %s. Does it have a public no-args constructor?", converter_class.getSimpleName()));
                }
        }

    private List<StepConverter> _converters = new ArrayList<>();

    private static StepConverters INSTANCE;
    final static Logger LOG = LoggerFactory.getLogger(StepConverters.class);
    }


