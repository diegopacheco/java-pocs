package com.ilegra.training.spring.integration.file;

import java.io.File;

/**
 * Spring Integration simple handler bean
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 04/05/2010
 * 
 */
public class Handler {
	
	public File handleFile(File input) {
		System.out.println("Copying file: " + input.getAbsolutePath());
		return input;
	}
	
}
