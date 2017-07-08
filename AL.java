package al;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

//program shows basic events and action/event listener method
// "event driven" architecture
public class AL extends JFrame implements ActionListener {
   TextField textbox = new TextField(60); 
   TextField textbox2 = new TextField(60);
   Button ButtonA,ButtonB,ButtonC; //3 button references set to null
   private int numClicks = 0;
   

 public static void main(String[] args) {
   //new up an object of this class.(AL).. 
   //if you do this, the object has a frame "built" in it  
   //no need to new up a frame 
  AL frame1 = new AL("SWING PGM THAT SHOWS A LISTENER METHOD AND EVENTS");
     frame1.setSize(700,450); //height, width of window
     frame1.setVisible(true);
     frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
             
   }
   //constructor that sets up the object with GUI and listeners
   //when you add to content pane in a constructor, just say "add"
   public AL(String title) {
     super(title); //call base class constructor and pass title
     this.setLayout(new FlowLayout());
     this.ButtonA = new Button("BUTTON A"); //fill in reference above
     this.ButtonA.setForeground(Color.RED);
     this.ButtonA.setBackground(Color.YELLOW);
     this.add(ButtonA); //add button A to the flowlayout
     ButtonA.addActionListener(this);//we want "actionperformed" method
                                          //called when button A is hit
                                      //the code for it is in this object below
     ButtonB = new Button("BUTTON B");  //"this" is not needed
     ButtonB.setForeground(Color.RED);
     ButtonB.setBackground(Color.YELLOW);
     add(ButtonB);
     ButtonB.addActionListener(this);//we want "actionperformed" method
                                    //called when button B is hit

     ButtonC = new Button("BUTTON C");
     add(ButtonC);
     ButtonC.setForeground(Color.RED);
     ButtonC.setBackground(Color.YELLOW);
      
     //set larger fonts for text boxes
     textbox.setFont( new Font("Monospaced", Font.BOLD, 24) );
     textbox2.setFont( new Font("Monospaced", Font.BOLD, 24) );
     add(textbox); //textbox1 for messages
     add(textbox2);//textbox2 for count of button clicks..now we wait
     // Button ButtonD = new Button("BUTTON DDD"); // why cant below access this?
      //add(ButtonD);  //try to access this in method below
     }
     
    //this method is called by java when some event occurs
     
   public void actionPerformed(ActionEvent e) {
                             //actioneven object is passed in here
                            //when an event(click) occurs
                           //look at e properties
        
     if (e.getSource() == ButtonA) { //was it button A?
       textbox.setText("BUTTON A WAS CLICKED--- ACTION A PERFORMED");}

     if (e.getSource() == ButtonB) { //was it button B ?
       textbox.setText("BUTTON B WAS CLICKED--- ACTION B PERFORMED");}

     if (e.getSource() == ButtonC) { //was it button C ?
                      
     textbox.setText("BUTTON C WAS CLICKED--- ACTION C PERFORMED");}
     //add to totals
     numClicks++;
     textbox2.setText("TOTAL BUTTONS CLICKED  --> " + numClicks + " TIMES");

    } //end actionperformed listener method
 } //end class AL
