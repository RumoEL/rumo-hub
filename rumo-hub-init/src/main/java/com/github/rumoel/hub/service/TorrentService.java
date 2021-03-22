package com.github.rumoel.hub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.rumoel.hub.dao.torrents.PeerRepository;
import com.github.rumoel.hub.dao.torrents.TorrentRepository;
import com.github.rumoel.rumoel.libs.pas.torrents.peer.PeerCounter;
import com.github.rumoel.rumoel.libs.pas.torrents.peer.PeerInfo;
import com.github.rumoel.rumoel.libs.pas.torrents.report.ReportForTorrentPeer;
import com.github.rumoel.rumoel.libs.pas.torrents.torrent.TorrentInfo;
import com.github.rumoel.rumoel.libs.pas.torrents.trackers.own.RumoBittorrentTrackerInfo;

@Service
public class TorrentService {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	TorrentRepository torrentRepository;
	@Autowired
	PeerRepository peerRepository;

	// TORRENT
	public void saveTorrent(TorrentInfo torrent) {
		boolean contain = torrentRepository.existsById(torrent.getHash());
		if (!contain) {
			torrentRepository.save(torrent);
			logger.info("{} is saved", torrent);
		}
	}

	public void saveReport(ReportForTorrentPeer report) {

		String reportID = report.getReportId();
		long reportTime = report.getTime();

		RumoBittorrentTrackerInfo reporter = report.getReporter();
		CopyOnWriteArrayList<String> aa = reporter.getTrackerIp();
		CopyOnWriteArrayList<PeerInfo> peerInfos = report.getPeerInfo();
		for (PeerInfo peerInfo : peerInfos) {
			String peerhash = peerInfo.getHash();

			String peerHost = peerInfo.getHost();
			int peerPort = peerInfo.getPort();
			String addr = peerHost + ":" + peerPort;

			TorrentInfo torrentInfo = peerInfo.getTorrent();

			List<PeerCounter> counters = peerInfo.getPeerCounters();
			for (PeerCounter peerCounter : counters) {
				// stringBuilder.append("[").append().append("]");
				StringBuilder stringBuilder = new StringBuilder();

				stringBuilder.append("[").append(reportTime).append("]");
				stringBuilder.append("[").append(reporter).append("]");
				stringBuilder.append("[").append(reportID).append("]");
				stringBuilder.append("[").append(peerhash).append("]");
				stringBuilder.append("[").append(addr).append("]");
				stringBuilder.append("[").append(torrentInfo).append("]");
				// stringBuilder.append("[").append().append("]");
				// stringBuilder.append("[").append().append("]");
				// stringBuilder.append("[").append().append("]");
				//
				System.err.println(stringBuilder);

			}
		}

	}

	public List<TorrentInfo> getAllTorrent() {
		ArrayList<TorrentInfo> list = new ArrayList<>();
		try {
			Iterable<TorrentInfo> dataI = torrentRepository.findAll();
			for (TorrentInfo torrent : dataI) {
				if (torrent.getHash() != null) {
					list.add(torrent);
				}
			}
		} catch (Exception e) {
		}
		return list;
	}// TORRENT

	public List<PeerInfo> getAllPeers() {
		ArrayList<PeerInfo> list = new ArrayList<>();
		try {
			Iterable<PeerInfo> dataI = peerRepository.findAll();
			for (PeerInfo peer : dataI) {
				if (peer.getHash() != null) {
					list.add(peer);
				}
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<PeerInfo> getAllPeersByTorrent(TorrentInfo torrent) {
		return peerRepository.getAllPeersByTorrent(torrent);
	}

}
