import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;


public class Nikakat extends MIDlet implements CommandListener, Runnable {
	private Form form, delform;
    private String[] stringElement = {"Region 1", "Region 2", "Region 3", "Region 4", "Region 5", "Region 6"};
    private ChoiceGroup group;
  private Form Vidscreen, cinema;
  private Item Viditem;
  private VideoControl Vidcontrol;
  private Command Playcommand, c5, c6, c7, c8, c9, c10, choose;
  private Player player = null;
  private String url = "http://www.youtube.com";
  private Display display;
  private List Mainlist;
  private Ticker ticker;
  private Form mainForm;
  private ImageItem Imgitem, Imgitem1;
  private Command exit, next, Next, last, back, send;
 
  private static final Command CMD_PRESS = new Command("Send", Command.ITEM, 1);
  private Image car, airplane, hotel, mobile, cartoon, flower, j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, share, cover,socialmedia;
  String[] stringElements = {"Single Image", "Image Slider", "About Us", "You tube", "Information","Trailer", "Lewedajo Yagaru", "nikakat drama", "Ye Gize Selieda"};
  
  public Nikakat(){
  try{
  airplane = Image.createImage("/icon.png");
  car = Image.createImage("/one.png");
  hotel = Image.createImage("/icon.png");
  mobile = Image.createImage("/one.png");
  cartoon = Image.createImage("/icon.png");
  flower = Image.createImage("/j24.png");
  share = Image.createImage("/share.png");
  socialmedia = Image.createImage("/socialmedia.png");
  j5 = Image.createImage("/j23.png");
  j6 = Image.createImage("/j22.png");
  j7 = Image.createImage("/j21.png");
  j8 = Image.createImage("/j20.png");
  j9 = Image.createImage("/j19.png");
  j10 = Image.createImage("/j15.png");
  j1 = Image.createImage("/j14.png");
  j2 = Image.createImage("/j16.png");
  j3 = Image.createImage("/j17.png");
  j4 = Image.createImage("/j18.png");
  cover= Image.createImage("/cover.png");
  }catch(Exception e){
  System.err.println(e.getMessage());
  }
  
  
  }

  public void startApp() {
	ticker = new Ticker ("WEL COME TO NIKAKAT!");
	display = Display.getDisplay(this);
	Image[] imageElements = {airplane, car, hotel, mobile, cartoon, mobile, cartoon, mobile, cartoon};
	Mainlist = new List("Choose an Option", List.IMPLICIT, 
	stringElements, imageElements);
	back = new Command("Back", Command.CANCEL, 0);
	send = new Command("Send", Command.SCREEN, 3);
	last = new Command("next", Command.SCREEN, 1);
	c5 = new Command("next", Command.SCREEN, 1);
	c6 = new Command("next", Command.SCREEN, 1);
	c7 = new Command("next", Command.SCREEN, 1);
	c8 = new Command("next", Command.SCREEN, 1);
	c9 = new Command("next", Command.SCREEN, 1);
	c10 = new Command("next", Command.SCREEN, 1);
	next = new Command("next", Command.SCREEN, 1);
	Next = new Command("next", Command.SCREEN, 2);
	exit = new Command("Exit", Command.EXIT, 0);
	Mainlist.addCommand(exit);
	Mainlist.setTicker(ticker);
	Mainlist.setCommandListener(this);
	Alert alert = new Alert("Selected", "                 WELCOME TO NIKAKAT .", cover, AlertType.INFO);
		display.setCurrent(alert,Mainlist);
  
  }

  public void pauseApp() {}

  public void destroyApp(boolean unconditional){
	  if (player != null) {
		player.close();
		}
	  notifyDestroyed();
   }
  
  public Form Vidfirst (){
	Vidscreen = new Form("NIKAKAT TRAILER");
	String space = "                                                    ";
	Vidscreen.append(space);
	Vidscreen.append(space);
	Vidscreen.append(space);
	Vidscreen.append(space);
	String info = "DO YOU REALLY WANT TO WATCH THE TRAILER OF NIKAKAT MOVIE ?";
	String info1 = "IF YES PRESS PLAY BUTTON";
	String info2 = "IF NO PRESS EXIT BUTTON";
	Vidscreen.append(info);
	Vidscreen.append(info1);
	Vidscreen.append(info2);
	Vidscreen.addCommand(exit);
	Playcommand = new Command("Play", Command.SCREEN, 0);
	Vidscreen.addCommand(Playcommand);
	Vidscreen.setCommandListener(this);
	return Vidscreen;
 }

  
  
   private void downloadPage(String url) throws IOException {
    StringBuffer b = new StringBuffer();
    InputStream is = null;
    HttpConnection c = null;
    TextBox t = null;
    try {
      long len = 0;
      int ch = 0;

      c = (HttpConnection) Connector.open(url, Connector.READ_WRITE);
      is = c.openInputStream();

      len = c.getLength();
      if (len != -1) {
        // Read exactly Content-Length bytes
        for (int i = 0; i < len; i++)
          if ((ch = is.read()) != -1)
            b.append((char) ch);
      } else {
        // Read till the connection is closed.
        while ((ch = is.read()) != -1) {
          len = is.available();
          b.append((char) ch);
        }
      }
      t = new TextBox("hello again....", b.toString(), 1024, 0);
    } finally {
      is.close();
      c.close();
    }

    display.setCurrent(t);
  }
 //-------------------------------------------------------------------------------------- 
  public Form Slide() {
	    Imgitem = new ImageItem("My FIRST IMAGE", flower, ImageItem.LAYOUT_CENTER, "image");
	    Form aForm = new Form(" Single ImageItem");
		String space = "                                  ";
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(Imgitem);
		aForm.addCommand(back);
		aForm.addCommand(Next);
		
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public Form five() {
	    Imgitem = new ImageItem("My FIVETH IMAGE", j5, ImageItem.LAYOUT_CENTER, "image");
	    Form aForm = new Form(" Single ImageItem");
		String space = "                                  ";
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(Imgitem);
		aForm.addCommand(back);
		aForm.addCommand(c6);
		
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public Form media() {
	    Imgitem = new ImageItem("", share, ImageItem.LAYOUT_CENTER, "image");
		Imgitem1 = new ImageItem("", socialmedia, ImageItem.LAYOUT_CENTER, "image");
	    Form aForm = new Form(" Lewedajo yagaru");
		aForm.append(Imgitem);
		aForm.append(Imgitem1);
		aForm.addCommand(back);
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public Form six() {
	    Imgitem = new ImageItem("My SIXTH IMAGE", j6, ImageItem.LAYOUT_CENTER, "image");
	    Form aForm = new Form(" Single ImageItem");
		String space = "                                  ";
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(Imgitem);
		aForm.addCommand(back);
		aForm.addCommand(c7);
		
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public Form seven() {
	    Imgitem = new ImageItem("My SEVENTH IMAGE", j7, ImageItem.LAYOUT_CENTER, "image");
	    Form aForm = new Form(" Single ImageItem");
		String space = "                                  ";
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(Imgitem);
		aForm.addCommand(back);
		aForm.addCommand(c8);
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public Form eight() {
	    Imgitem = new ImageItem("My EIGHTH IMAGE", j8, ImageItem.LAYOUT_CENTER, "image");
	    Form aForm = new Form(" Single ImageItem");
		String space = "                                  ";
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(Imgitem);
		aForm.addCommand(back);
		aForm.addCommand(c9);
		
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public Form nine() {
	    Imgitem = new ImageItem("My NINETH IMAGE", j9, ImageItem.LAYOUT_CENTER, "image");
	    Form aForm = new Form(" Single ImageItem");
		String space = "                                  ";
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(Imgitem);
		aForm.addCommand(back);
		aForm.addCommand(c10);
		
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public Form ten() {
	    Imgitem = new ImageItem("My TENTH IMAGE", j10, ImageItem.LAYOUT_CENTER, "image");
	    Form aForm = new Form(" Single ImageItem");
		String space = "                                  ";
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(Imgitem);
		aForm.addCommand(back);
		aForm.addCommand(exit);
		
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public Form addDropDownList() {
        
        form = new Form("Ye Gize Selieda");
        group = new ChoiceGroup("Select Choice", Choice.POPUP, stringElement, null);
        choose = new Command("SELECT", Command.OK, 1);
        exit = new Command("EXIT", Command.EXIT, 1);
        
        // Add Field into Form  
        form.append(group);
        form.addCommand(choose);
        form.addCommand(exit);
        form.setCommandListener(this);
		return form;
    }

	
  public Form contact_us () {
		mainForm = new Form("Contact us");
        mainForm.append( "  **********************************************************                                                 "+"                                      "+"This demo application is developed by                       "+" HILMIKA TECH SOLUTION values"+"                   WEBSITE: www.hilimikatech.com                "+"   ADDRESS: around Atlas Babu bld 2nd floor  "+"                 PHONE_NO:+251 911 210 420    " + "                                                  " + "                                      **********************************************************                                            ");

        mainForm.append(new TextField("Your Message ", "", 15, TextField.ANY));
        mainForm.append(new TextField("Your E-Mail", "", 15, TextField.EMAILADDR));
	    mainForm.append(cartoon);
		mainForm.append(cartoon);
		mainForm.append(cartoon);
		mainForm.append(cartoon);
	    
		mainForm.addCommand(send);
        mainForm.addCommand(back);
        mainForm.setCommandListener(this); 
	    return mainForm;
  }
  
  public Form SingleImage () {
	    Imgitem = new ImageItem(" MAIN PRODUCER ", flower, ImageItem.LAYOUT_CENTER, "image");
	    Form aForm = new Form(" Single ImageItem");
		String space = "                                  ";
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(Imgitem);
		aForm.addCommand(back);
		aForm.addCommand(exit);
		
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public Form simpletext () {
	  Form aForm = new Form(" Some Information");
	  String space = "                                                    ";
	  StringItem item =
            new StringItem("This is a place holder for the bold string item: ", "");
	  String info =  "         This is simple text of information    ";
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(space);
		aForm.append(item);
		aForm.append(info);
		aForm.append(info);
		aForm.append(info);
		aForm.append(info);
		aForm.append(info);
		aForm.addCommand(back);
		aForm.addCommand(exit);
		aForm.setCommandListener(this);
		return aForm;
  }
  
  public void commandAction(Command c, Item i) {
  
  if(c==send)
  {
   Alert alert = new Alert("Selected", "Your Message Has Been Sent Successfully.", cartoon, AlertType.INFO);
   display.setCurrent(alert, Mainlist);
  }
 }
  
  public void commandAction(Command c, Displayable d) {
	   Alert alert = new Alert("Selected", "Your Message Has Been Sent Successfully.", cartoon, AlertType.INFO);
	   
	   
        if (d.equals(Mainlist)) {
            // in the main list
            if (c == List.SELECT_COMMAND) {
                if (d.equals(Mainlist)) {
                    switch (((List)d).getSelectedIndex()) {
                    case 0:
						display.setCurrent(SingleImage());

                        break;

                    case 1:
                      					
							display.setCurrent(Slide());
							break;

                    case 2:
                        display.setCurrent(contact_us());

                        break;
					case 3:
                        if(true){
							try {
								downloadPage(url);
								} catch (IOException e) {
									}
						}
                        break;
                    case 4:
                        display.setCurrent(simpletext());

                        break;
					case 5:
                        display.setCurrent(Vidfirst());

                        break;
				    case 6:
                        display.setCurrent(media());

                        break;
					case 7:
                        display.setCurrent(Vidfirst());

                        break;
					case 8:
                        display.setCurrent(addDropDownList());

                        break;
                    }
                }
            }
        } 
		
		if (c== next){
			Imgitem = new ImageItem("My THIRD IMAGE", j4, ImageItem.LAYOUT_CENTER, "image");
			Form aForm = new Form("ImageItem");
			String space =  "                  ";
				aForm.append(space);
				aForm.append(space);
				aForm.append(space);
				aForm.append(space);
			aForm.append(Imgitem);
			aForm.addCommand(back);
			aForm.addCommand(last);
			aForm.setCommandListener(this);
			display.setCurrent(aForm);
		
		}
		if (c== Next){
			Imgitem = new ImageItem("My SECOND IMAGE", j2, ImageItem.LAYOUT_CENTER, "image");
			Form aForm = new Form("ImageItem");
			String space =  "                     ";
			aForm.append(space);
			aForm.append(space);
			aForm.append(space);
			aForm.append(space);
			aForm.append(Imgitem);
			aForm.addCommand(back);
			aForm.addCommand(next);
			//aForm.addCommand(next);
			aForm.setCommandListener(this);
			display.setCurrent(aForm);
		
		}
		
		if (c == choose) {
            // Display selected Choices from List
			boolean isFirst=true;
            StringItem item = new StringItem("Time Table for ",group.getString(group.getSelectedIndex()));
            form.append(item);
			String region = group.getString(group.getSelectedIndex());
			String timetable = "";
			if(region=="Region 1"){
				timetable=" Monday and Tuesday at night";
			}
			else if(region=="Region 2"){
				
				timetable=" Wednesday and Tuesday at night";
			}
			else if(region=="Region 3"){
				
				timetable=" Wednesday and Friday night";
			}
			else if(region=="Region 4"){
				
				timetable=" Thursday and Friday night";
			}
			else if(region=="Region 5"){
				
				timetable=" Sunday and Friday night";
			}
			else if(region=="Region 6"){
				
				timetable=" Saturday and Friday night";
			}
			form.append(timetable);
            display.setCurrent(d);
        }
		
		if (c== last){
			Imgitem = new ImageItem("My FOURTH IMAGE", j1, ImageItem.LAYOUT_CENTER, "image");
			Form aForm = new Form("ImageItem");
			String space =  "                  ";
				aForm.append(space);
				aForm.append(space);
				aForm.append(space);
				aForm.append(space);
				aForm.append(Imgitem);
				aForm.addCommand(c5);
				aForm.addCommand(exit);
			
				aForm.setCommandListener(this);
				display.setCurrent(aForm);
		}
		
		if (c== back){
			startApp();
		}
		if (c== c5){
			display.setCurrent(five());
		}
		if (c== c6){
			display.setCurrent(six());
		}if (c== c7){
			display.setCurrent(seven());
		}if (c== c8){
			display.setCurrent(eight());
		}if (c== c9){
			display.setCurrent(nine());
		}
		if (c== c10) {
			display.setCurrent(ten());
		}
		if (c== send){
			display.setCurrent(alert, Mainlist);
		}
        if (c == exit) {
            destroyApp(false);
            notifyDestroyed();
        }
		if (c== Playcommand){
				Form waitForm = new Form("Loading...");
				display.setCurrent(waitForm);
				Thread t = new Thread(this);
				t.start();
				/*Process process = new Process(this);
				process.start();*/ 
		}
    }
	
	public void run() {
		playFromResource();
	}
	private void playFromResource() {
		try {
			InputStream in = getClass().getResourceAsStream("/phantom.mpg");
			player = Manager.createPlayer(in, "video/mpeg");
			player.realize();
			if ((Vidcontrol = (VideoControl)
				player.getControl("VideoControl")) != null) {
				Viditem = (Item)
				Vidcontrol.initDisplayMode(VideoControl.USE_GUI_PRIMITIVE, null);
				cinema = new Form ("Nikakat trailer");
				String space = "                                                    ";
				cinema.append(space);
				cinema.append(space);
				cinema.append(space);
				cinema.append(space);
			
				cinema.append(Viditem);
				String info = "                                                                                           ENJOY THE TRAILER OF NIKAKAT                  MOVIE ENJOY THE TRAILER OF NIKAKAT            MOVIEENJOY THE TRAILER OF NIKAKAT         ";
				cinema.append(info);
			}
			player.start();
			display.setCurrent(cinema);
		}
		catch (Exception e) {
		showException(e);
		return;
		}
	}
	
	private void showException(Exception e) {
		Alert a = new Alert("Exception", e.toString(), null, null);
		a.setTimeout(Alert.FOREVER);
		display.setCurrent(a, Mainlist);
	}
	
	class Process implements Runnable{
  private Nikakat MIDlet;

  public Process(Nikakat MIDlet){ 
  this.MIDlet = MIDlet;
  System.out.println("Thread Process...");
  }

  public void run(){
  try{
  transmit();
  StringBuffer b = new StringBuffer();
    InputStream is = null;
    HttpConnection c = null;
    TextBox t = null;
    try {
      long len = 0;
      int ch = 0;

      c = (HttpConnection) Connector.open(url, Connector.READ_WRITE);
      is = c.openInputStream();

      len = c.getLength();
      if (len != -1) {
        // Read exactly Content-Length bytes
        for (int i = 0; i < len; i++)
          if ((ch = is.read()) != -1)
            b.append((char) ch);
      } else {
        // Read till the connection is closed.
        while ((ch = is.read()) != -1) {
          len = is.available();
          b.append((char) ch);
        }
      }
      t = new TextBox("hello again....", b.toString(), 1024, 0);
	  
    } finally {
      is.close();
      c.close();
    }

    display.setCurrent(t);
  }catch(Exception error){ 
  System.err.println(error.toString());
  }  
  }

  public void start(){
  Thread thread = new Thread(this);
  try{
  thread.start();
  System.out.println("Thread Start...");
  }catch(Exception error){}
  }
  private void transmit() throws IOException{} 

}
  }

