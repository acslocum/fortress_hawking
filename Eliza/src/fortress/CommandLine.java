package fortress;

import Eliza.*;
import java.io.*;

public class CommandLine {
	public static String readLine() throws Exception{
		String s = "";
		try {
			InputStreamReader converter = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(converter);
			s = in.readLine();
		} catch (Exception e) {
			System.out.println("Error! Exception: "+e); 
		}
		return s;
	}
		
	public static void main(String args[]) throws Exception {
		ElizaMain eliza = new ElizaMain();
		eliza.readScript(true, "script");
		eliza.runProgramOnStream(System.in);
	}
}