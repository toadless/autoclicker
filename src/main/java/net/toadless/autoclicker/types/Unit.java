package net.toadless.autoclicker.types;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public enum Unit
{
    MILLISECOND(TimeUnit.MILLISECONDS, "Millisecond"),
    SECONDS(TimeUnit.SECONDS, "Second"),
    MINUTE(TimeUnit.MINUTES, "Minute"),
    HOUR(TimeUnit.HOURS, "Hour"),
    DAY(TimeUnit.DAYS, "Day");



    private final TimeUnit timeUnit;
    private final String identifier;

    Unit(TimeUnit timeUnit, String identifier)
    {
        this.timeUnit = timeUnit;
        this.identifier = identifier;
    }

    public TimeUnit getTimeUnit()
    {
        return this.timeUnit;
    }

    public String getIdentifier()
    {
        return this.identifier;
    }

    public static Unit[] getUnits()
    {
        return Unit.class.getEnumConstants();
    }

    public static String[] getIdentifiers()
    {
        final List<String> identifiers = new LinkedList<>();

        for (Unit unit : getUnits())
        {
            identifiers.add(unit.getIdentifier());
        }

        return identifiers.toArray(new String[0]);
    }
}