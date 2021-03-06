package org.platformlayer.ops;

import java.util.EnumSet;
import java.util.Enumeration;

import org.apache.log4j.Logger;

public class EnumUtils {
    static final Logger log = Logger.getLogger(EnumUtils.class);

    public static <T> T getOnly(Enumeration<T> enumeration) {
        if (!enumeration.hasMoreElements())
            throw new IllegalStateException("No elements found in enumeration");

        T retval = enumeration.nextElement();
        if (enumeration.hasMoreElements())
            throw new IllegalStateException("Found more than one element in enumeration");

        return retval;
    }

    public static <T extends Enum<T>> T valueOfCaseInsensitive(Class<T> enumType, String name) {
        if (name == null)
            return null;
        for (T enumValue : EnumSet.allOf(enumType)) {
            if (enumValue.toString().equalsIgnoreCase(name))
                return enumValue;
        }
        throw new IllegalArgumentException("Unknown value for " + enumType + ": " + name);
    }

    public static <T extends Enum<T>> T valueOfOrNull(Class<T> enumType, String name) {
        if (name == null)
            return null;
        for (T enumValue : EnumSet.allOf(enumType)) {
            if (enumValue.toString().equals(name))
                return enumValue;
        }
        return null;
    }
}
