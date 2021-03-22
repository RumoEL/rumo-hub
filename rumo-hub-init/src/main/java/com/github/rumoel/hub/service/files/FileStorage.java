package com.github.rumoel.hub.service.files;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.github.rumoel.hub.service.files.FileStorageImpl.processedIf;

public interface FileStorage {
	public void store(MultipartFile file, processedIf noprocessed, String userName, String project);

	public Resource loadFile(String filename, processedIf noprocessed, String username, String project);

	public void deleteAll();

	public void init();

	public Stream<Path> loadFiles();
}