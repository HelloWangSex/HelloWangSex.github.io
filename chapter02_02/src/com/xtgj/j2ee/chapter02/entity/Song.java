package com.xtgj.j2ee.chapter02.entity;
public class Song {
	private int id; // 歌曲编号
	private String name; // 歌名
	private String singer; // 歌手名
	private String album; // 专辑名
	private int catld; // 所属分类编号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getCatld() {
		return catld;
	}
	public void setCatld(int catld) {
		this.catld = catld;
	}
     
}
