package PolecenieV2;

public class WashingMachineOffComm implements ICommand{
    WashingMachine washingMachine;
    static int prevState;

    public WashingMachineOffComm(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }


    @Override
    public void execute() {
        prevState = washingMachine.getActivState();
        washingMachine.Off();
    }

    @Override
    public void undo() {
        switch (prevState){
            case 0: //off
                washingMachine.Off();
                break;
            case 1:
                washingMachine.On();
                break;
            case 2://norm
                washingMachine.Normal();
                break;
            case 3://fast
                washingMachine.Fast();
                break;

        }
    }
}
