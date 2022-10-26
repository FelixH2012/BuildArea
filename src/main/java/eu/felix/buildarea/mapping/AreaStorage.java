package eu.felix.buildarea.mapping;

import java.util.ArrayList;

public class AreaStorage {

    public static ArrayList<AreaData> areas = new ArrayList<>();

    public static AreaData getByName(final String name) {
        for (final AreaData areaData : areas) {
            if (areaData.getAreaName().equalsIgnoreCase(name))
                return areaData;
        }
        return null;
    }

}
