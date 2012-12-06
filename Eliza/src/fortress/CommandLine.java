package fortress;

import Eliza.*;
import java.io.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandLine extends TimerTask{
	private static Logger logger = LogManager.getLogger("Eliza");
	public static long DELAY = 2 * 60 * 1000;
	public static long PERIOD = 2 * 60 * 1000;
	ElizaMain eliza;
	long previousRandomPickupLine;
	
	public CommandLine() throws Exception {
		eliza = new ElizaMain();
		eliza.readScript(true, "script");
		previousRandomPickupLine = new Date().getTime();
	}
	
	public void chat() throws Exception {
		eliza.runProgramOnStream(System.in);
	}
	
	public void run() {
		if(eliza.lastInput() < previousRandomPickupLine) {
			String pickup = eliza.randomPickupLine();
			System.out.println(pickup);
			logger.info("PL " + pickup);
		}
		previousRandomPickupLine = new Date().getTime();
	}
		
	public static void main(String args[]) throws Exception {
		CommandLine commandLine = new CommandLine();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(commandLine, CommandLine.DELAY, CommandLine.PERIOD);
		while(true) {
			commandLine.chat();
		}
	}
}