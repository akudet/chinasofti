package demo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileuploadController {

	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IllegalStateException,
			IOException {

		System.out.println("AJSDASDASDasDASDAS");

		file.transferTo(new File("D:/tmp/" + file.getOriginalFilename()));

		return "redirect:index.jsp";
	}
	
	@RequestMapping("/one")
	public String one() {
		return "redirect:index.jsp";
	}

}
