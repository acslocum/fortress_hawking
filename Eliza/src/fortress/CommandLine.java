package fortress;

import Eliza.*;
import java.io.*;
import java.util.*;

public class CommandLine extends TimerTask{
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
			System.out.println(eliza.randomPickupLine());
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