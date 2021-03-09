package com.github.rumoel.hub.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.rumoel.hub.dao.torrents.PeerRepository;
import com.github.rumoel.hub.dao.torrents.TorrentRepository;
import com.github.rumoel.rumoel.libs.pas.torrents.Peer;
import com.github.rumoel.rumoel.libs.pas.torrents.Torrent;

@Service
public class TorrentService {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	TorrentRepository torrentRepository;
	@Autowired
	PeerRepository peerRepository;

	// TORRENT
	public void saveTorrent(Torrent torrent) {
		boolean contain = torrentRepository.existsById(torrent.getHash());
		if (!contain) {
			torrentRepository.save(torrent);
			logger.info("{} is saved", torrent);
		}
	}

	public List<Torrent> getAllTorrent() {
		ArrayList<Torrent> list = new ArrayList<>();
		try {
			Iterable<Torrent> dataI = torrentRepository.findAll();
			for (Torrent torrent : dataI) {
				if (torrent.getHash() != null) {
					list.add(torrent);
				}
			}
		} catch (Exception e) {
		}
		return list;
	}// TORRENT

	public List<Peer> getAllPeers() {
		ArrayList<Peer> list = new ArrayList<>();
		try {
			Iterable<Peer> dataI = peerRepository.findAll();
			for (Peer peer : dataI) {
				if (peer.getHash() != null) {
					list.add(peer);
				}
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Peer> getAllPeersByTorrent(Torrent torrent) {
		return peerRepository.getAllPeersByTorrent(torrent);
	}
}
