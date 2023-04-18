package org.example;

public class TimeKeeper implements Runnable {
    private final long startTime;
    private final long timeLimit;
    private final Exploration exploration;

    public TimeKeeper(long timeLimit, Exploration exploration) {
        this.startTime = System.currentTimeMillis();
        this.timeLimit = timeLimit;
        this.exploration = exploration;
    }

    /**
     * Am implementat un timer, ce arata din 5 in 5 secunde cat timp a trecut de cand a pornit explorarea
     */
    @Override
    public void run() {
        while (System.currentTimeMillis() - startTime < timeLimit) {
            try {
                Thread.sleep(5000);
                System.out.println("Elapsed time: " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Timpul a expirat");
        exploration.stop();
    }
}
