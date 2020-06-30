import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.util.Timer;
import java.util.TimerTask;

public class TwentyTwentyTwenty {

    public static void main(String[] args) throws AWTException {
    Timer t = new Timer(); 
    TimerTask timer = new TimerTask() {
    public void run() {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("eye.png"));
        TrayIcon tr = new TrayIcon(image, "perm"); 
        tr.setImageAutoSize(true); 
        tr.setToolTip("20-20-20");
        try {
			tray.add(tr);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("202020");
        try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        trayIcon.displayMessage("It has been 20 minutes, look 20 feet away for 20 seconds", "20-20-20", MessageType.NONE);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tray.remove(trayIcon);
    }
    };
    t.schedule(timer, 1000 * 60 * 20, 1000 * 60 * 20); //repeat task every 20 minutes
    }
}