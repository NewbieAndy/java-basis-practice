package com.newbieandy.java.thread.jcip;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MonitorVehicleTracker {
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocatjon(String id) {
        MutablePoint mutablePoint = locations.get(id);
        return null == mutablePoint ? null : new MutablePoint(mutablePoint);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint mutablePoint = locations.get(id);
        if (null == mutablePoint) {
            throw new IllegalArgumentException("No such ID: " + id);
        }

        mutablePoint.x = x;
        mutablePoint.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> map = new HashMap<String, MutablePoint>();
        for (String key : m.keySet()) {
            map.put(key, new MutablePoint(m.get(key)));
        }
        return Collections.unmodifiableMap(map);
    }
}
