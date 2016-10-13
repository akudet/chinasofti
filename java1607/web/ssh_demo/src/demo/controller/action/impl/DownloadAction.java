package demo.controller.action.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

public class DownloadAction {

	private String filename;

	public String getFilename() {
		
		try {
			return new String(filename.getBytes("utf-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public InputStream getStream() {
		final String FILES_DIR = ServletActionContext.getServletContext().getRealPath("/files");
		File file = new File(FILES_DIR, filename);
		
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String download() {
		System.out.println("DOWNLOAD : " + filename);
		return "success";
	}

}
