package com.github.rumoel.rumoel.libs.pas.torrents.torrent;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "torrents")
public class TorrentInfo implements Serializable {
	private static final long serialVersionUID = -1311685397040187997L;
	@Getter
	@Setter
	@Id
	@Column
	private String hash;
	@Getter
	@Setter
	@Column
	private String createdByVersion;
	@Getter
	@Setter
	@Column
	private String createdByName;
	@Getter
	@Setter
	@Column
	private long createdDate;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TorrentInfo [");
		if (hash != null) {
			builder.append("hash=");
			builder.append(hash);
			builder.append(", ");
		}
		if (createdByVersion != null) {
			builder.append("createdByVersion=");
			builder.append(createdByVersion);
			builder.append(", ");
		}
		if (createdByName != null) {
			builder.append("createdByName=");
			builder.append(createdByName);
			builder.append(", ");
		}
		builder.append("createdDate=");
		builder.append(createdDate);
		builder.append("]");
		return builder.toString();
	}

}
