package utilities;

import java.util.Timer;
import java.util.TimerTask;

public class SetTimer {
	
    Timer timer;

    public SetTimer(int seconds) {
        timer = new Timer();
        timer.schedule(new SetTimerTask(), seconds*1000);
	}

    class SetTimerTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        new SetTimer(5);
        System.out.println("Task scheduled.");
    }
	

}
