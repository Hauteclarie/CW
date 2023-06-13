package com.Janus.Core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
	File logFile;
	File bMemoryFile;
	File kbMemoryFile;
	File mbMemoryFile;
	File gbMemoryFile;
	FileWriter writer;
	Scanner reader;
	
	public FileHandler() {
		logFile = new File("log.txt");
		bMemoryFile = new File("B.txt");
		kbMemoryFile = new File("KB.txt");
		mbMemoryFile = new File("MB.txt");
		gbMemoryFile = new File("GB.txt");
	}
	
	public void logResult(String result, String unit) throws IOException {
		if(unit == "B") {
			writer = new FileWriter(bMemoryFile, true);
			writer.flush();
			writer.write(result + "<br/>");
			writer.close();
		}else if (unit == "KB") {
			writer = new FileWriter(kbMemoryFile, true);
			writer.flush();
			writer.write(result + "<br/>");
			writer.close();
		}else if (unit == "MB") {
			writer = new FileWriter(mbMemoryFile, true);
			writer.flush();
			writer.write(result + "<br/>");
			writer.close();
		}else if (unit == "GB") {
			writer = new FileWriter(gbMemoryFile, true);
			writer.flush();
			writer.write(result + "<br/>");
			writer.close();
		}
	}
	
	public void saveResult(String result) throws IOException {
		writer = new FileWriter(logFile, true);
		writer.flush();
		writer.write(result + "<br/>");
		writer.close();
	}
	
	public String readFile(String fileString) throws FileNotFoundException {
		String dataString = null;
		
		if(fileString == "B") {
			reader = new Scanner(bMemoryFile);
			dataString = reader.nextLine();
			reader.close();
		}else if (fileString == "KB") {
			reader = new Scanner(kbMemoryFile);
			dataString = reader.nextLine();
			reader.close();
		}else if (fileString == "MB") {
			reader = new Scanner(mbMemoryFile);
			dataString = reader.nextLine();
			reader.close();
		}else if (fileString == "GB") {
			reader = new Scanner(gbMemoryFile);
			dataString = reader.nextLine();
			reader.close();
		}else if (fileString == "log") {
			reader = new Scanner(logFile);
			dataString = reader.nextLine();
			reader.close();
		}
		
		return dataString;
		
	}
}
