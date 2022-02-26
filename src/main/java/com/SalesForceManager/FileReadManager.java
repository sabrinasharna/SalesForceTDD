package com.SalesForceManager;

import com.SalesForceConfigFileReader.ConfigFileReader;

public class FileReadManager {
	
private FileReadManager () {
		
	}
private static FileReadManager fileReadManager= new FileReadManager();

public static FileReadManager getInstance() {
	return fileReadManager;	
}

ConfigFileReader configFileReader;
public ConfigFileReader getConfigReader() {
	return (configFileReader==null)? new ConfigFileReader():configFileReader;
	
}

}
