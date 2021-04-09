package com.github.rumoel.rumoel.libs.pas.torrents.trackers.own;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.Getter;
import lombok.Setter;

public class RumoBittorrentTrackerInfo implements Serializable {

	private static final long serialVersionUID = 3040123149723087563L;
	@Getter
	private String id = UUID.randomUUID().toString();

	@Getter
	@Setter
	private CopyOnWriteArrayList<String> trackerIp = new CopyOnWriteArrayList<>();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RumoBittorrentTrackerInfo [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (trackerIp != null) {
			builder.append("trackerIp=");
			builder.append(trackerIp);
		}
		builder.append("]");
		return builder.toString();
	}

}
