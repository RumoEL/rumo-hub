package com.github.rumoel.rumoel.libs.pas.torrents.peer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.rumoel.rumoel.libs.pas.torrents.torrent.TorrentInfo;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "peers")
public class PeerInfo implements Serializable {
	private static final long serialVersionUID = -3322920320950469695L;
	@Getter
	@Setter
	@Id
	@Column
	private String hash;
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private TorrentInfo torrent;

	@Getter
	@Setter
	@Column
	private String host;
	@Getter
	@Setter
	@Column
	private int port;

	@Getter
	@Setter
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ElementCollection
	@CollectionTable(name = "peerlists", joinColumns = @JoinColumn(name = "peerinfo_id"))
	private List<PeerCounter> peerCounters = new ArrayList();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PeerInfo [");
		if (hash != null) {
			builder.append("hash=");
			builder.append(hash);
			builder.append(", ");
		}
		if (torrent != null) {
			builder.append("torrent=");
			builder.append(torrent);
			builder.append(", ");
		}
		if (host != null) {
			builder.append("host=");
			builder.append(host);
			builder.append(", ");
		}
		builder.append("port=");
		builder.append(port);
		builder.append(", ");
		if (peerCounters != null) {
			builder.append("peerCounters=");
			builder.append(peerCounters);
		}
		builder.append("]");
		return builder.toString();
	}

}
