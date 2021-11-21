import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;

class Main
  {
  public static void main(String[] args)
    {
    ProcessBuilder processBuilder = new ProcessBuilder();

    try
    {
      while (true)
      {
        List<String> builderList = new ArrayList<String>();

	String commandInput = "";
	System.out.print(String.format("\u001B[31mjava@bashmod\u001B[0m:\u001B[32m$\u001B[0m %s", commandInput));

	Scanner scanIt = new Scanner(System.in);
        commandInput = scanIt.nextLine();
	commandInput = commandInput + " > .std 2>&1; cat .std && rm .std";

	Collections.addAll(builderList, "/bin/sh", "-c", commandInput);

        processBuilder.command(builderList);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;

        while((line = reader.readLine()) != null)
        {
          System.out.println(line);
        }
      }
    }

    catch(IOException e)
    {
      e.printStackTrace();
    }
  }
}
