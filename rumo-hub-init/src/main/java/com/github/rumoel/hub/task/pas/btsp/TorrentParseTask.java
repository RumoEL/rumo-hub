package com.github.rumoel.hub.task.pas.btsp;

import com.github.rumoel.hub.task.Task;

import lombok.Getter;
import lombok.Setter;

public class TorrentParseTask extends Task {
	@Getter
	@Setter
	byte[] data;

	@Override
	public void execute() {
		// TODO PARSE TORRENT
	}
}
