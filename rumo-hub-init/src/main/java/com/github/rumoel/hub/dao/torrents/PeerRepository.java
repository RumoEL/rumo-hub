package com.github.rumoel.hub.dao.torrents;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.rumoel.rumoel.libs.pas.torrents.peer.PeerInfo;
import com.github.rumoel.rumoel.libs.pas.torrents.torrent.TorrentInfo;

@Repository
public interface PeerRepository extends CrudRepository<PeerInfo, String> {

	ArrayList<PeerInfo> getAllPeersByTorrent(TorrentInfo torrent);
}