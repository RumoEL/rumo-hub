package com.github.rumoel.libs.core.project;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Project implements Serializable {
	private static final long serialVersionUID = 5528033428916366708L;

	@Getter
	@Setter
	String name;
	@Getter
	@Setter
	String version;
	@Getter
	@Setter
	String versionGit;
	@Getter
	@Setter
	String filePath;
}
