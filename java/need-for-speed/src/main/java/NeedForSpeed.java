class NeedForSpeed {
        private int speed;
        private int batteryDrain;
        private int distance;
        private int batteryCharge = 100;

        NeedForSpeed(int speed, int batteryDrain) {
            this.speed = speed;
            this.batteryDrain = batteryDrain;
        }

        public boolean batteryDrained() {
            return batteryCharge <= 0;
        }

        public int distanceDriven() {
            return distance;
        }

        public void drive() {
            if (batteryCharge >= batteryDrain) {
                distance += speed;
                batteryCharge -= batteryDrain;
            }
        }

        public static NeedForSpeed nitro() {
            return new NeedForSpeed(50, 4);
        }
    }

    class RaceTrack {
        private int trackDistance;

        RaceTrack(int trackDistance) {
            this.trackDistance = trackDistance;
        }

        public boolean tryFinishTrack(NeedForSpeed car) {
            while (!car.batteryDrained()) {
                car.drive();
            }
            
            return car.distanceDriven() >= trackDistance;
        }
    }