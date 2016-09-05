package jtwu.listener;

import java.io.*;
import java.util.Scanner;

import javax.servlet.*;

public class CountListener implements ServletContextListener {

	// TODO : refactor file op
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		
		String count_path = sc.getRealPath("/WEB-INF/count.txt");
		System.out.println(count_path);
		File count_file = new File(count_path);
		
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(count_file);
			// TODO : get ride of using this string directly
			Integer count = (Integer) sc.getAttribute("count");
			pw.println(count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != pw) {
				pw.close();
			}
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		
		String count_path = sc.getRealPath("/WEB-INF/count.txt");
		System.out.println(count_path);
		File count_file = new File(count_path);
		
		Scanner scan = null;
		try {
			scan = new Scanner(count_file);
			Integer count = Integer.parseInt(scan.nextLine());
			// TODO : get ride of using this string directly
			sc.setAttribute("count", count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != scan) {
				scan.close();
			}
		}
	}

}
