package com.github.diegopacheco.design.patterns._extra.balking;

public class WashingMachine {

    private WashingMachineState washingMachineState;

    public WashingMachine() {
        washingMachineState = WashingMachineState.ENABLED;
    }

    public WashingMachineState getWashingMachineState() {
        return washingMachineState;
    }

    public void wash() {
        synchronized (this) {
            System.out.println(String.format("%s: Actual machine state: %s", Thread.currentThread().getName(), getWashingMachineState()));
            if (washingMachineState == WashingMachineState.WASHING) {
                System.out.println("ERROR: Cannot wash if the machine has been already washing!");
                return;
            }
            washingMachineState = WashingMachineState.WASHING;
        }
        System.out.println(String.format("%s: Doing the washing", Thread.currentThread().getName()));
        silentSleep();
        endOfWashing();
    }

    public synchronized void endOfWashing() {
        washingMachineState = WashingMachineState.ENABLED;
        System.out.println(String.format("%s: Washing completed.", Thread.currentThread().getId()));
    }

    private void silentSleep(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException ie) {}
    }

}
