package edu.ssafy.boot.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	@RequestMapping("/fileuploadpage")
	public String fileUploadPage() {
		return "fileupload";
	}
	
	@RequestMapping("/fileupload")
	public @ResponseBody Map<String,String> fileUpload(HttpServletRequest req) {
		System.out.println(req.getParameter("name"));
		String path="c:/aaa";
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		Map<String, String> resObj = new HashMap<String, String>();
		
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
		
		Iterator<String> fileNames = mhsr.getFileNames();
		
		if(!f.isDirectory()) {
			f.mkdir();
		}
		try {
			while (fileNames.hasNext()) {
				String fileName = (String) fileNames.next();
				MultipartFile file = mhsr.getFile(fileName);
				
				String oriName = new String(file.getOriginalFilename().getBytes("UTF-8"), "UTF-8");
				String ext = oriName.substring(oriName.lastIndexOf("."));
				
				String saveFileName = oriName;
				
				File serverFile = new File(path+File.separator+saveFileName);
				
				file.transferTo(serverFile);
				
				resObj.put("res", "file transfer success");
			}
		} catch (UnsupportedEncodingException e) {
			resObj.put("res", "file transfer failure");
			e.printStackTrace();
		} catch (IllegalStateException e) {
			resObj.put("res", "file transfer failure");
			e.printStackTrace();
		} catch (IOException e) {
			resObj.put("res", "file transfer failure");
			e.printStackTrace();
		}
		
		return resObj;
	}
}
