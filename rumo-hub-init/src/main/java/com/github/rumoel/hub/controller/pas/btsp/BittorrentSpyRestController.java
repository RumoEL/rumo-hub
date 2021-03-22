package com.github.rumoel.hub.controller.pas.btsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.rumoel.hub.service.TorrentService;
import com.github.rumoel.rumoel.libs.pas.torrents.report.ReportForTorrentPeer;

@RestController
public class BittorrentSpyRestController {
	@Autowired
	TorrentService torrentService;

	@PostMapping(path = "/api/insecure/pasbitspy", consumes = "application/json", produces = "application/json")
	public void add(@RequestBody ReportForTorrentPeer report) {
		// reconService.save(hostPort);

		System.err.println(1);
		torrentService.saveReport(report);
		System.err.println(2);
		// System.err.println(report);
	}
}
