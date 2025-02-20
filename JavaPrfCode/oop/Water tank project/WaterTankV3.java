import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class WaterLevelObserver extends JFrame{
    public void update(int waterLevel){
        System.out.println("Observer not found!");
    }
}

//devices

class DisplayFrame extends WaterLevelObserver{
    private JLabel displayLabel;

    DisplayFrame(){
        setSize(400, 400);
        setTitle("Display");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        displayLabel = new JLabel("50");
        displayLabel.setFont(new Font("", Font.BOLD, 35));
        add(displayLabel);

        setVisible(true);
    }

    public void update(int waterLevel){
        if(waterLevel >= 0 && waterLevel <= 100){
            this.displayLabel.setText(Integer.toString(waterLevel));
        }
    }
}

class AlarmFrame extends WaterLevelObserver{
    private JLabel alarmLabel;

    AlarmFrame(){
        setSize(400, 400);
        setTitle("Alarm");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        alarmLabel = new JLabel("Off");
        alarmLabel.setFont(new Font("", Font.BOLD, 35));
        add(alarmLabel);

        setVisible(true);
    }

    public void update(int waterLevel){
        if(waterLevel >= 0 && waterLevel <= 100){
            this.alarmLabel.setText(waterLevel >= 80 ? "On" : "Off");
        }
    }
}

class SplitterFrame extends WaterLevelObserver{
    private JLabel splitterLabel;

    SplitterFrame(){
        setSize(400, 400);
        setTitle("Splitter");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        splitterLabel = new JLabel("Off");
        splitterLabel.setFont(new Font("", Font.BOLD, 35));
        add(splitterLabel);

        setVisible(true);
    }

    public void update(int waterLevel){
        if(waterLevel >= 0 && waterLevel <= 100){
            this.splitterLabel.setText(waterLevel >= 90 ? "On" : "Off");
        }
    }
}

class SendMessageFrame extends WaterLevelObserver{
    JLabel messageSenderDisplay;
    SendMessageFrame(){
        setSize(400,400);
        setTitle("Message Sender");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        messageSenderDisplay = new JLabel("No Message Send");
        messageSenderDisplay.setFont(new Font("",Font.BOLD,35));
        add(messageSenderDisplay);
        setVisible(true);
    }

    public void update(int waterLevel){
            this.messageSenderDisplay.setText("SMS Sending : "+ waterLevel);
    }
}

//Device Controller
class WaterTankController{
    private int waterLevel;

    private static WaterLevelObserver [] observers = new WaterLevelObserver[0];

    public void setWaterLevel(int waterLevel){
        this.waterLevel = waterLevel;
        notifyObjects();
    }

    public void notifyObjects(){
        for(WaterLevelObserver device: observers){
            device.update(waterLevel);
        }
    }

    public static void addWaterTankController(WaterLevelObserver waterLevelObserver){
        WaterLevelObserver [] tempObservers = new WaterLevelObserver[observers.length+1];
        for (int i = 0; i < observers.length; i++) {
            tempObservers[i] = observers[i];
        }
        tempObservers[observers.length] = waterLevelObserver;
        observers = tempObservers;
    }
}

//Water Tank
class WaterTank extends JFrame{
    private JSlider waterLevelSlider;

    private WaterTankController waterTankController;

    WaterTank(){
        setSize(400, 500);
        setTitle("Water Tank");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        waterLevelSlider = new JSlider(JSlider.VERTICAL);
        waterLevelSlider.setMajorTickSpacing(10);
        waterLevelSlider.setPaintLabels(true);
        waterLevelSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int waterLevel = waterLevelSlider.getValue();
                waterTankController.setWaterLevel(waterLevel);
            }
        });

        add(waterLevelSlider);

        setVisible(true);
    }

    public void setWaterTankController(WaterTankController waterTankController){
        this.waterTankController = waterTankController;
    }
}

class Main{
    public static void main(String[] args) {

        WaterTankController waterTankController = new WaterTankController();
        waterTankController.addWaterTankController(new AlarmFrame());
        waterTankController.addWaterTankController(new DisplayFrame());
        waterTankController.addWaterTankController(new SplitterFrame());
        waterTankController.addWaterTankController(new SendMessageFrame());

        WaterTank waterTank = new WaterTank();
        waterTank.setWaterTankController(waterTankController);
    }
}
