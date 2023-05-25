class TwoBucket {
    private int bucketOneCap;
    private int bucketTwoCap;
    private final int desiredLiters;
    private final String startBucket;

    TwoBucket(int bucketOneCap, int bucketTwoCap, int desiredLiters, String startBucket) {
        this.bucketOneCap = bucketOneCap;
        this.bucketTwoCap = bucketTwoCap;
        this.desiredLiters = desiredLiters;
        this.startBucket = startBucket;
    }

    int getTotalMoves() {
        int moves = 0;

        while (bucketOneCap != desiredLiters || bucketTwoCap != desiredLiters) {
            int bucket = bucketOneCap;
            bucketTwoCap += bucket;

            moves++;
        }

        return moves;
    }

    String getFinalBucket() {
        throw new UnsupportedOperationException("Please implement the TwoBucket.getFinalBucket() method.");
    }

    int getOtherBucket() {
        throw new UnsupportedOperationException("Please implement the TwoBucket.getOtherBucket() method.");
    }
}
