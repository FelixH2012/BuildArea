package eu.felix.buildarea.mapping;

import eu.felix.buildarea.utils.TimerUtil;
import org.bukkit.Location;

public class AreaData {
    private Location firstLocation, secondLocation;

    private final String areaName;

    private int resetDelay;

    public TimerUtil timerUtil = new TimerUtil();

    public boolean isAllowToRun = false;

    public AreaData(final String areaName, final Location firstLocation, final Location secondLocation, final int resetDelay) {
        this.areaName = areaName;
        this.firstLocation = firstLocation;
        this.secondLocation = secondLocation;
        this.resetDelay = resetDelay;
    }


    public void setFirstLocation(Location firstLocation) {
        this.firstLocation = firstLocation;
    }

    public void setSecondLocation(Location secondLocation) {
        this.secondLocation = secondLocation;
    }

    public String getAreaName() {
        return areaName;
    }

    public int getResetDelay() {
        return resetDelay;
    }

    public void setResetDelay(int resetDelay) {
        this.resetDelay = resetDelay;
    }

    public Location getFirstLocation() {
        return firstLocation;
    }

    public Location getSecondLocation() {
        return secondLocation;
    }

}
