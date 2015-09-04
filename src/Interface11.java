import javax.microedition.io.Connector;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

import javax.wireless.messaging.*;

public class Interface11 extends MIDlet implements ItemStateListener, ItemCommandListener, CommandListener, Runnable 
{
    private Display di;

    private Form homeForm,logoForm,eventsForm,smsForm,helpForm;
    private Form aboutus,contactus,presentation,workshop;
    private Form masterfcodes,cdciper,oops,algo,microgalaxy,webcrackers;
    private Form admaniac,scrabble,stuff,sensonair,gamadrome,direczcorner,photoclenza;

    private int isEventForm;
    private int index;
	
    private String coordinator[] = new String[]{"VIGNESH.K","CHOZHAN.D.M","RAJAGOPAL.M","NAGANATHAN.N","THEOPAUL.K.A","PRAVEEN KUMAR.R","CHOZHAN.D.M","ADITHYAN.U","VIJAY VENKATESH.K.V.J","NAVEEN PRABHU.S.D","PRASHANTH.M","VARUN KUMAR.S","KARTHIKAI KANNAN"};
    private String contacts[] = new String[]{"+919789266439","+919952236841","+919791800572","+919894940145","+919629620683","+919585597659","+919952236841","+919629109280","+919944565258","+919952387510","+919865885810","+919597828209","+919790185805"};
    private String[] strings,eventStrings;
	private String address;
	
    private Image[] images,eventImages;
	
    private ChoiceGroup exGroup,eventGroup;

    private MessageConnection smsconn;
    
	private TextField queryCoordinat =new TextField("Coordinator Name::", "", 100, TextField.ANY);
    private TextField queryField =new TextField("Query::", "", 100, TextField.ANY);
    
    private Image home;
    private Image im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12,im13;

    private Command exitCommand = new Command("Exit", Command.EXIT, 2);
    private Command nextCommand = new Command("Next", Command.SCREEN, 1);
    private Command backCommand = new Command("Back", Command.SCREEN, 1);
    private Command sendCommand = new Command("Send", Command.EXIT, 2);
    private Command smsCommand = new Command("SMS Query",Command.EXIT,2);
//--------------------------------------------------------------------------------------------------------------
    public Interface11() {
	di=Display.getDisplay(this);
// image set

try{
		home = Image.createImage("/home.jpg");
		im1 = Image.createImage("/image1.png");
		im2 = Image.createImage("/image2.png");
		im3 = Image.createImage("/image3.png");
		im4 = Image.createImage("/image4.png");
		im5 = Image.createImage("/image5.png");
		im6 = Image.createImage("/image6.png");
		im7 = Image.createImage("/image7.png");
		im8 = Image.createImage("/image8.png");
		im9 = Image.createImage("/image9.png");
		im10 = Image.createImage("/image10.png");
		im11 = Image.createImage("/image11.png");
		im12 = Image.createImage("/image12.png");
		im13 = Image.createImage("/image13.png");
	}catch(Exception e)
	{
		System.out.println(e.toString());
	}

	images = new Image[] { im1,im2,im8,im4,im7 };
	strings = new String[] { "Events", "About Us", "Contact Us","Presentation","Workshop"};
 	exGroup = new ChoiceGroup("Choose one", ChoiceGroup.EXCLUSIVE,strings, images);

	eventImages = new Image[] { im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12,im13 };
	eventStrings = new String[] {"Master Of Codes","C Decipherz","Oops!! Wat the funda","Algo Rhythmz","Microgalaxy","Webcrackerz","Admaniac","Scrabble","Watz Ur Stuff","Sensonair","Gamindrome","Directorz Corner","Photoclenza"};
 	eventGroup = new ChoiceGroup("Choose an Event", ChoiceGroup.EXCLUSIVE,eventStrings, eventImages);
	//eventGroup.setListener(this);

//home Form set
	homeForm=new Form("Home"); 
	homeForm.append(home);
	homeForm.addCommand(exitCommand); 
	homeForm.addCommand(nextCommand); 
	homeForm.setCommandListener(this);
        homeForm.setCommandListener(this); 

// logo Form set
	logoForm = new Form("Interface11");
	logoForm.addCommand(backCommand);
	logoForm.append(exGroup);
	exGroup.setSelectedIndex(exGroup.append("Help", null), true);
	logoForm.setItemStateListener(this);
	logoForm.setCommandListener(this);

// events Form
	eventsForm = new Form("Events");
	eventsForm.addCommand(backCommand);
	eventsForm.append("Description about events");
	eventsForm.append(eventGroup);
	eventGroup.setSelectedIndex(eventGroup.append("Help", null), true);
	eventsForm.setItemStateListener(this);
        eventsForm.setCommandListener(this);

// masterfcodes Form
	masterfcodes = new Form("Master Of Codes");
	masterfcodes.addCommand(backCommand);
        masterfcodes.setCommandListener(this);  
	masterfcodes.append("Are you smart as a whip in steering a system or manipulating a database? Fabricate data into various structures or can you wangle digitals?Then here is a fiesta for all you young athirist book folks.\n RULES::\n ROUND 1: In this round, you will be given a  choice of choosing among areas like Operating  Systems, DBMS, Data Structures and languages(C, C++, JAVA). Select any three among the areas mentioned  and answer to the aptitude questions within an hour. \n ROUND 2: The selected candidates will be given a  scenario and code the solution within 45 minutes.The top coders from the second round  will be interviewed.The winner will be qualified for THE BEST OF INTERFACE (IT).");
 	masterfcodes.addCommand(smsCommand);

// cdciper Form
	cdciper = new Form("C Decipherz");
	cdciper.addCommand(backCommand);
        cdciper.setCommandListener(this);
	cdciper.append("C-DECIPHERZ \n Hey geeks heed here. This is how you can use the excellent boost to manage scope for your objective-C objects, be dare enough to trod our tract and confront the knotty oppugn squarely. \n RULES::\nROUND 1: Solve the aptitude questions from C language and the candidates will be  selected based on their performance.Time - 40 minutes \n ROUND 2: The selected candidates from the first  round has to debug the code with the time limit of 40 minutes.\n ROUND 3: The best debugger has to code for the  given programs using the language and the best performer enter into THE  BEST OF INTERFACE (IT).");
	cdciper.addCommand(smsCommand);
// oops Form
	oops = new Form("OOPS!! WAT THE FUNDA");
	oops.addCommand(backCommand);
        oops.setCommandListener(this);
	oops.append("OOPS!! WAT THE FUNDA \n How could one be a ne plus ultra in the rudiment? Operas to describe and arduous to remember, but for a local pedestrian it's the obvious one. ctrl+s else OOPS!! itz gone .\n RULES::\n ROUND 1: Solve the aptitude questions fromv C++, JAVA with the time limit of 35  minutes and the candidates will be selected based on their performance. \n ROUND 2: Code the given programs using the  language JAVA and the best  performer enter into THE BEST OF INTERFACE (IT) Time - 1 hour.");
	oops.addCommand(smsCommand);
// algo Form
	algo = new Form("ALGO-RHYTHMZ");
	algo.addCommand(backCommand);
        algo.setCommandListener(this);
	algo.append("ALGO-RHYTHMZ \n Versalitily isn't always a good thing. This might be stretching the realms of jazz code,we would never have to ponder the question *Is there a better way to do it ?* itz going to be a plenteous glean so feed your nous in steganography.\n RULES:: \n ALGO-RHYTHMZ: (TEAM EVENT-2 MEMBERS PER  TEAM OR INDIVIDUAL EVENT) \n ROUND 1: Present the algorithm for the given problem  using the MICROSOFT expected area (DATA  STRUCTURES) Time - 45 minutes \n ROUND 2: The best performers from the first round  has to code the algorithm for the given real time application using C, C++. Best coder enters the grand event THE BEST OF INTERFACE (IT). Time -1 hour.");
	algo.addCommand(smsCommand);;
// microgalaxy Form
	microgalaxy = new Form("MICROGALAXY");
	microgalaxy.addCommand(backCommand);
        microgalaxy.setCommandListener(this);
	microgalaxy.append("MICROGALAXY \n Itz the piazza to usher your originality by unriddling the fuddling interrogation, be brawny as your opponent is a herculean who is 8085 years old and exotic to spoof. He is on the way from the microgalaxy to dummy run your endowment. \n RULES:: \n MICROGALAXY: (TEAM EVENT-2 MEMBERS PER TEAM  OR INDIVIDUAL EVENT) \n ROUND 1: Crack your mind by answering the  crossword puzzles from the basic processor 8085 and the latest processors. Time - 45 minutes \n ROUND 2: The selected candidate has to code the  instruction for a given problem on the 8085 kit.Time - 1 hour.");
	microgalaxy.addCommand(smsCommand);
// webcrackers Form
	webcrackers = new Form("WEBCRACKERZ ");
	webcrackers.addCommand(backCommand);
        webcrackers.setCommandListener(this);
	webcrackers.append("WEBCRACKERZ \n Are you the hoi polloi who have been darned for transgressing things ? Then bash the conundrums with de jure for which you would be regaled with extolment. Bust the irksome entanglement into pecks with your groundbreaking scout.\n RULES:: \n WEBCRACKERZ : (INDIVIDUAL EVENT) \n ROUND 1: Solve the aptitude questions from C language and the candidates will be  selected based on their performance.Time - 40 minutes \n ROUND 2: The selected candidates from the first  round has to debug the code with the time limit of 40 minutes.");
	webcrackers.addCommand(smsCommand);
// admaniac Form
	admaniac = new Form("ADMANIAC");
	admaniac.addCommand(backCommand);
        admaniac.setCommandListener(this);
	admaniac.append("ADMANIAC \n Wherever you go in cantonment make the people around you to grumble about your adept.  An amender always would consider what follows from the positivist perspective. We are looking out for the most proficient commove wielder.");
	admaniac.addCommand(smsCommand);


// scrabble Form
	scrabble = new Form("Scrabble");
	scrabble.addCommand(backCommand);
        scrabble.setCommandListener(this);
	scrabble.append("SCRABBLE \n Itz a posse where we hound for words and where antagonists reckon at each other and phonetics would be anglicised. Get ready with your ebuillence to combat aganist the burnished bright. \n RULES:: \n ROUND 1: Its  an individual round. Aptitude questions related to English  (phrases,synonyms,antonyms,proverbs,quotes) will be given. Time for this event  is 30 min. \n ROUND 2: Its  a Just a Minute round of expressing your views. The candidates will be given a  topic in the spot. They have to speak few words related to that topic for a  minute. \n ROUND 3: The  filtered candidates from 2nd round will be split into teams. About  10 words will be given for each team. They have to frame a story using these  words. The time given for this round is 10 min.");
	scrabble.addCommand(smsCommand);

// stuff Form
	stuff= new Form("WATZ UR STUFF");
	stuff.addCommand(backCommand);
        stuff.setCommandListener(this);
	stuff.append("WATZ UR STUFF \n Do you regret that your quite simpleton? then here are few childlike scientific explainable phenomena. This event is being plunged to feat the queer and hunch of the keen participants. This on-stage event that trials their cognizance about the how and why of matters around us and aperients behind everyday occurrences.\n RULES:: \n WATZ  UR STUFF \n ROUND 1: Its  an individual round to shake your mind for 30 min. You have to find your  answers in the given puzzles and justify your reasons. \n ROUND 2: Its  a round for testing your creativity. You have to build the proposed model from  the given junk material. For example, building the model of ant by using  sponge.");
	stuff.addCommand(smsCommand);
// sensonair Form
	sensonair = new Form("Sensonair");
	sensonair.addCommand(backCommand);
        sensonair.setCommandListener(this);
	sensonair.append("SENSONAIR \n Boost your brain and stretch your memory with this classic engrossment. We spellbind you with our on-stage event to transfix from perturb. Blaze away the beguilement to pull ahead of all focused mindwaves.\n RULES:: \n SENSONAIR: \n Round 1: Each  team will consist of 5 members. Your team will be given a video clip which can  be visualized by any one of your team members who will make the running  commentary on that video clip. Finally questions will be asked to other members  of that team on what they infer from the commentary.Note: Teams will be split by the  corresponding event representatives.\n  Round 2: Each team consists of 5 members.A slide  show of celebrities will be shown and question about those celebrities will be  asked and the selection criteria is based on the answers and the number of  celebrities you remember.\n Round 3: Its  an individual round for testing your capability of doing three activities  simultaneously. On hearing the music, you have to align the shuffled alphabets  and also at the same instance you have to answer to the questions being asked  to you. All has to be done in 1 min. At the end of a min, questions will be  asked about the music played in the background.");
	sensonair.addCommand(smsCommand);

// gamadrome Form
	gamadrome = new Form("GAMINDROME");
	gamadrome.addCommand(backCommand);
        gamadrome.setCommandListener(this);
	gamadrome.append("GAMINDROME \n Itz the gamers asylum who would furore to concoct a plot. Wild blitzkrieg awaits to wail. All you zealot embarrass your awesomeness and frolic around our systemz.");
	gamadrome.addCommand(smsCommand);

// direczcorner Form
	direczcorner = new Form("DIRECTORZ CORNER");
	direczcorner.addCommand(backCommand);
        direczcorner.setCommandListener(this);
	direczcorner.append("DIRECTORZ CORNER (SHORT - FILMS) \n These are invisible archives of greatness. Here, the camera is an objective moment of subjectivity, swimming on the difficult waters of bondage and liberation. They are perhaps the only genre of creative craft with no strings attached to corporate entities.");
	direczcorner.addCommand(smsCommand);
// photoclenza Form
	photoclenza = new Form("Photoclenza");
	photoclenza.addCommand(backCommand);
        photoclenza.setCommandListener(this);
	photoclenza.append("PHOTOCLENZA \n Are you a sneak in collaging the snaps ? Here is a photo funda for you to click at .Grab your scimitar to crave a scintillating scenario.Ricochet the wacky pictures and etch your pinnacle in photography.");
	photoclenza.addCommand(smsCommand);



// aboutus Form
	aboutus = new Form("About Us");
	aboutus.addCommand(backCommand);
        aboutus.setCommandListener(this);
	aboutus.append("Coimbatore institute of technology is an  institution that stands for excellence and continuously sets the highest  standards. As one of the very old colleges established, our college, has a  glorious history as it has contributed many distinguished personalities and  leaders in diverse fields. Institutions with great heritage may not always  perpetuate the good traditions and the quality but here is an example  wherein,CIT has shown to be an exception. Its educational environment is  stimulating which ensures freedom of thinking and action as well as  responsibility and honesty. The College is unique in imparting truly  value-based education, which manifests in the multifarious extension activities  aiming to enhance social welfare.");
// contactus Form
	contactus = new Form("Contact Us");
	contactus.addCommand(backCommand);
        contactus.setCommandListener(this);
	contactus.append("ANY QUERIES EVENTS AND HOSPITALITY \n\n VIJAY VENKATESH.K.V.J \n EMAIL :chairman@interface11.com \n CONTACT NO.: +919944565258  \n RAMESH.M.S \n EMAIL:eventmanagers@interface11.com \n CONTACT NO.: +919944934175 \n\n SPONSORS DETAILS::  \n AVINESH.S \t CONTACT NO.: +919790224320 \n  NANDHINI.C \t CONTACT NO.: +919629281485 \n\n PRESENTATIONS:: \nCHOZHAN.D.M.\t CONTACT NO.: +919952236841 \nKAVITHA.K \t CONTACT NO.: +917708362400 \n ADITHYAN.U \t CONTACT NO.: +919629109280 \n DEVAMALAR.A \t CONTACT NO.:+919047639073 ");
// presentation Form
	presentation = new Form("Presentations");
	presentation.addCommand(backCommand);
        presentation.setCommandListener(this);
	presentation.append("TECH TALKIES \n Present your paper to get presents. The topics should be based on the following areas \n 1. Image Processing \n 2. Network Security \n 3. Cloud Computing \n 4. Open Source Technology \n 5. 4G and 5G \n 6. Grid Computing \n 7.Artificial Intelligence \n The Registration for the paper presentation is closed. \n HARDWARE & SOFTWARE PRESENTATION \n Bring your innovative [hard/soft]wares and win exciting prizes. \n Registration closed.\n Result to be announced on 15th january. \n For results visit www.interface11.com .");
// workshop Form
	workshop = new Form("Workshops");
	workshop.addCommand(backCommand);
        workshop.setCommandListener(this);
	workshop.append("WORKSHOP 1: \n WORKSHOP ON J2ME AND J2EE ORGANISED BY NIIT WITH DEPT OF IT OF CIT AND PRESENTATIONS FROM SUN MICROSYSTEM'S CERTIFIED MEMEBRS ON 23rd JANUARY 2011 \n Registration closed.\n ON THE SPOT REGISTRATION AVAILABLE (For limited members - In first come first serve basis)\n\n WORKSHOP 2:\n WORKSHOP ON ETHICAL HACKING BY MAZENET WITH DEPT OF IT OF CIT ON 22rd JANUARY 2011.\n Registration open.");

// SMS Form
	smsForm = new Form("Sms The Coordinator");
	smsForm.addCommand(backCommand);
	smsForm.addCommand(sendCommand);
        smsForm.setCommandListener(this);
	smsForm.append("Submit the query via SMS ** Standard SMS Costs applicable\n");
	smsForm.append(queryCoordinat);
	smsForm.append(queryField);
// help Form
	helpForm = new Form("Help");
	helpForm.addCommand(backCommand);
         	helpForm.setCommandListener(this);
	helpForm.append("The Home Form let you know the details of the institution,symposiums and workshops\n\nThe Event Form contains the list of events that are being conducted and choosing the event will let you know the details of the Event and its Rules. These forms also allows you to query the corresponding event Co-ordinator via SMS");
  
  }// constructor ends
//----------------------------------------------------------------------------------------------------------------------------


    protected void startApp() {
	    di.setCurrent(homeForm);
          
    }

    protected void destroyApp(boolean unconditional) {
    }

    protected void pauseApp() {
    }


    public void itemStateChanged( Item i) {
	if (i == exGroup) 
	{
	   isEventForm=0;
	   String gotOption =exGroup.getString(exGroup.getSelectedIndex());
		if(gotOption.equals("Events"))
		{
			di.setCurrent(eventsForm);
		}
		if(gotOption.equals("About Us"))
		{
			di.setCurrent(aboutus);
		}
		if(gotOption.equals("Contact Us"))
		{
			di.setCurrent(contactus);

		}
		if(gotOption.equals("Presentation"))
		{
			di.setCurrent(presentation);

		}
		if(gotOption.equals("Workshop"))
		{
			di.setCurrent(workshop);

		}
		if(gotOption.equals("Help"))
		{
			di.setCurrent(helpForm);
			isEventForm=0;

		}
		//exGroup.setSelectedIndex(5, true);
		
	}
	if (i == eventGroup) 
	{
	   String gotOption =eventGroup.getString(eventGroup.getSelectedIndex());
	   isEventForm=1;
		if(gotOption.equals("Master Of Codes"))
		{
			di.setCurrent(masterfcodes);
			index=0;
		}
		if(gotOption.equals("C Decipherz"))
		{
			di.setCurrent(cdciper);
			index=1;
		}
		if(gotOption.equals("Oops!! Wat the funda"))
		{
			di.setCurrent(oops);
			index=2;
		}
		if(gotOption.equals("Algo Rhythmz"))
		{
			di.setCurrent(algo);
			index=3;

		}
		if(gotOption.equals("Microgalaxy"))
		{
			di.setCurrent(microgalaxy);
			index=4;

		}
		if(gotOption.equals("Webcrackerz"))
		{
			di.setCurrent(webcrackers);
			index=5;

		}
		if(gotOption.equals("Admaniac"))
		{
			di.setCurrent(admaniac);
			index=6;
		}
		if(gotOption.equals("Scrabble"))
		{
			di.setCurrent(scrabble);
			index=7;
		}
		if(gotOption.equals("Watz Ur Stuff"))
		{
			di.setCurrent(stuff);
			index=8;

		}
		if(gotOption.equals("Sensonair"))
		{
			di.setCurrent(sensonair);
			index=9;

		}
		if(gotOption.equals("Gamindrome"))
		{
			di.setCurrent(gamadrome);
			index=10;

		}
		if(gotOption.equals("Directorz Corner"))
		{
			di.setCurrent(direczcorner);
			index=11;

		}
		if(gotOption.equals("Photoclenza"))
		{
			di.setCurrent(photoclenza);
			index=12;

		}
		if(gotOption.equals("Help"))
		{
			di.setCurrent(helpForm);
			isEventForm=1;

		}
             //eventGroup.setSelectedIndex(13, true);
	}
    }

	
     public void commandAction(Command c, Item i) 
     {

     }
	 
     public void commandAction(Command c, Displayable s) 
     {
        if (c == exitCommand)
	 {
            destroyApp(false);
            notifyDestroyed();
        }
        if (c == nextCommand)
	 {
            di.setCurrent(logoForm);
        }
	if (c == sendCommand)
	 {
            try {
			//sets address to send message
			String addr = "sms://"+contacts[index];
			// opens connection
			MessageConnection conn = (MessageConnection) Connector.open(addr);
			// prepares text message
			TextMessage msg = (TextMessage)conn.newMessage(MessageConnection.TEXT_MESSAGE);
			//set text
			msg.setPayloadText(queryField.getString());
			// send message
			conn.send(msg);
			conn.close();
		}
		catch(SecurityException se)
		{
			System.out.println("Security::"+se.toString());
		}
		catch (Exception e)
		{
			System.out.println("Error::"+e.toString());
		}
        }
	if (c == smsCommand)
	 {
        di.setCurrent(smsForm);
	    queryCoordinat.setString(coordinator[index]);
        }
	if (c == backCommand)
        {
		if(s == logoForm)
		{
		  di.setCurrent(homeForm);
		}
		else if(isEventForm==0)
		{
		  di.setCurrent(logoForm);
		}
		else if(isEventForm==1)
		{
		 di.setCurrent(eventsForm);
		 isEventForm=0;
		}
		if(s == smsForm)
		{
		  di.setCurrent(eventsForm);
		}
        }
	
   }
	public void run()
	{
		
	}

};
