package com.github.rumoel.hub.service.files;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.rumoel.hub.header.RumoHubHeader;

@Service
public class FileStorageImpl implements FileStorage {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public enum processedIf {
		PROCESSED, NOPROCESSED
	}

	// format
	// files/$project/$processedIf/$USER/$fileName
	// files/$project/$processedIf/$USER/$fileName

	private Path rootLocation = RumoHubHeader.getROOTDIR().toPath().resolve("files");

	@Override
	public void store(MultipartFile file, processedIf noprocessed, String username, String project) {
		try {
			File saveDir = rootLocation.resolve(project).resolve(noprocessed.toString()).resolve(username).toFile();
			if (!saveDir.exists()) {
				saveDir.mkdirs();
				saveDir.mkdir();
			}
			Path path = new File(saveDir.toPath().toFile(), file.getOriginalFilename()).toPath();

			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}

	@Override
	public Resource loadFile(String filename, processedIf noprocessed, String username, String project) {
		try {
			Path file = rootLocation.resolve(project).resolve(noprocessed.toString()).resolve(username)
					.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error! -> message = " + e.getMessage());
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}

	@Override
	public Stream<Path> loadFiles() {
		try {
			return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation))
					.map(this.rootLocation::relativize);
		} catch (IOException e) {
			throw new RuntimeException("\"Failed to read stored file");
		}
	}
}