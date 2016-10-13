package demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class TestFileUpload extends ActionSupport {

	File file;
	String fileFileName;
	String fileContentType;
	
	List<String> files;

	public List<String> getFiles() {
		return files;
	}


	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String upload() throws Exception {
		System.out.println(file + " " + fileContentType);
		System.out.println(fileFileName);

		String destDir = ServletActionContext.getServletContext().getRealPath(
				"/files");
		System.out.println(destDir);

		File dest = new File(destDir, fileFileName);

		copy(file, dest);

		return "sc";
	}
	
	public String index() {
		String filesDirPath = ServletActionContext.getServletContext().getRealPath(
				"/files");
		File filesDir = new File(filesDirPath);
		
		files = new ArrayList<String>();
		
		for (File file : filesDir.listFiles()) {
			files.add(file.getName());
		}
		return "index";
	}

	// will replace @to file if exists
	private void copy(File from, File to) throws IOException {
		/*
		if (to.exists()) {
			to.delete();
		}
		from.renameTo(to);
		*/
		
		int BUFFER_SIZE = 32 * 1024 * 1024;
		
		FileInputStream is = new FileInputStream(from);
		FileOutputStream os = new FileOutputStream(to);
		
		byte[] buff = new byte[BUFFER_SIZE];
		
		int length;
		while ((length = is.read(buff)) > 0) {
			os.write(buff, 0, length);
		}
		
		is.close();
		os.close();
	}

}
