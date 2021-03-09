package com.github.rumoel.hub.dao.torrents;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.rumoel.rumoel.libs.pas.torrents.Peer;
import com.github.rumoel.rumoel.libs.pas.torrents.Torrent;

@Repository
public interface PeerRepository extends CrudRepository<Peer, String> {

	ArrayList<Peer> getAllPeersByTorrent(Torrent torrent);
}