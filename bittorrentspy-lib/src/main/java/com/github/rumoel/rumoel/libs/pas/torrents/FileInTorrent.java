package com.github.rumoel.rumoel.libs.pas.torrents;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class FileInTorrent implements Serializable {

	private static final long serialVersionUID = -3819981565635747363L;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private long length;
}
