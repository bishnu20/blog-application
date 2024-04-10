package com.bhusal.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bhusal.service.FileService;
@Service
public class FileSystemImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// file name
		String name = file.getOriginalFilename();
		// randomly generate file name
		String randomId = UUID.randomUUID().toString();
		String newFile = randomId.concat(name.substring(name.lastIndexOf(".")));
		// full path
		String filePath = path + File.separator+ newFile;
		
		// create a folder if not created
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		//file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return newFile;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
