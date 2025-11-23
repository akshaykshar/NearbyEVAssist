package com.nearby.evassist.data.location;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MockLocationProvider {

    public interface Listener {
        void onLocation(double lat, double lng);
    }

    private final List<Listener> listeners = new ArrayList<>();
    private Timer timer;

    @Inject
    public MockLocationProvider() {
        // Hilt can now construct this dependency
    }

    public void start() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double lat = 59.0;
            double lng = 10.0;

            @Override
            public void run() {
                lat += 0.001;
                lng += 0.001;
                for (Listener l: listeners)
                    l.onLocation(lat, lng);
            }
        }, 0, 3000);
    }

    public void stop() {
        if (timer!=null) timer.cancel();
    }

    public void addListener(Listener l) {
        listeners.add(l);
    }

    public void removeListener(Listener l) {
        listeners.remove(l);
    }
}
