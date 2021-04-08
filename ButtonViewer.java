import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonViewer {
    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 100;

    private JFrame frame;
    private JPanel panel;
    private JButton buttonA;
    private JButton buttonB;
    private JLabel label;


    private int clickCountA;
    private int clickCountB;

    public ButtonViewer(){
        this.clickCountA = 0;
        this.clickCountB = 0;


        //1. Define and setup user interface components
        this.frame = new JFrame();
        this.panel =  new JPanel();

        this.buttonA = new JButton("Click Me!");
        this.panel.add(this.buttonA); //adding button to panel with panel.add() method

        this.buttonB = new JButton("No, Click Me!");
        this.panel.add(this.buttonB); //adding button to panel with panel.add() method

        this.label = new JLabel("0 clicks");
        this.panel.add(this.label);

        this.frame.add(this.panel);

        //2. create listener objects
        ClickListener listener = new ClickListener();

        //3.register listener objects with components that generate events
        this.buttonA.addActionListener(listener); //tying button click event to the listener
        this.buttonB.addActionListener(listener);


        this.frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public class ClickListener implements ActionListener { //object that can accept different types of events

        @Override
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == buttonA){
                clickCountA++;

        }
            else if(event.getSource() == buttonB){
                clickCountB++;

            }
            label.setText("A: " + clickCountA + " clicks; B:" + clickCountB + " clicks");
        }

    }

   public static void main(String[] args) {
        ButtonViewer viewer = new ButtonViewer();

    }





}

