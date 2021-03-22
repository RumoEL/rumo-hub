package com.github.rumoel.rumoel.libs.pas.torrents.trackers.other;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class TrackerInfo implements Serializable {

	private static final long serialVersionUID = 8439159689171266343L;

	public enum protocol {
		TCP, UDP
	}

	@Getter
	@Setter
	private protocol proto;
	@Getter
	@Setter
	private String host;
	@Getter
	@Setter
	private int port;
}
