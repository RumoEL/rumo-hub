package com.github.rumoel.hub.dao.torrents;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.rumoel.rumoel.libs.pas.torrents.torrent.TorrentInfo;

@Repository
public interface TorrentRepository extends CrudRepository<TorrentInfo, String> {

}
