package struts2demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

public class DownloadAction {

	private String filename = "你好.txt";
	private File downloadFile = new File("D:\\x.txt");

	public String getEncodedFilename() {
		
		try {
			return URLEncoder.encode(filename, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
	}

	public InputStream getDownloadFile() {
		try {
			return new FileInputStream(downloadFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setDownloadFile(File downloadFile) {
		this.downloadFile = downloadFile;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String download() {
		System.out.println(downloadFile);
		return "success";
	}

}
