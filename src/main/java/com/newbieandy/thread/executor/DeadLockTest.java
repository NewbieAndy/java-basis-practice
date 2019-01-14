package com.newbieandy.thread.executor;

import java.util.HashSet;
import java.util.Set;

public class DeadLockTest {
    class Taxi {
        private Point locatoin, destination;
        private final Dispatcher dispatcher;

        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocatoin() {
            return this.locatoin;
        }

        public void setLocatoin(Point locatoin) {
            boolean reacheDestination;
            synchronized (this) {
                this.locatoin = locatoin;
                reacheDestination = locatoin.equals(destination);
            }
            if (reacheDestination) {
                dispatcher.notifyAvailable(this);
            }
        }
    }

    private class Point {
    }

    private class Dispatcher {
        private final Set<Taxi> taxis;
        private final Set<Taxi> avaliableTaxis;

        public Dispatcher() {
            taxis = new HashSet<Taxi>();
            avaliableTaxis = new HashSet<Taxi>();
        }

        public synchronized void notifyAvailable(Taxi taxi) {
            avaliableTaxis.add(taxi);
        }

        public Image getImage() {
            Set<Taxi> copy;
            synchronized (this) {
                copy = new HashSet<>(taxis);
            }
            Image image = new Image();
            for (Taxi t : copy) {
                image.drawMarker(t.getLocatoin());
            }
            return image;
        }

    }

    private class Image {
        public void drawMarker(Point locatoin) {
        }
    }
}
