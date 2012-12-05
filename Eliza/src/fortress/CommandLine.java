package fortress;

import Eliza.*;
import java.io.*;

public class CommandLine {
	public static void chat() throws Exception {
		ElizaMain eliza = new ElizaMain();
		eliza.readScript(true, "script");
		eliza.runProgramOnStream(System.in);
	}
		
	public static void main(String args[]) throws Exception {
		while(true) {
			chat();
		}
	}
}