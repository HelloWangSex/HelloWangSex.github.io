package com.xtgj.j2ee.chapter02.user.biz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xtgj.j2ee.chapter02.db.DBUtil;
import com.xtgj.j2ee.chapter02.entity.Category;
import com.xtgj.j2ee.chapter02.entity.Song;

public class Business {
	Connection conn = null;

	// 返回所有分类信息
	public List findAllCategories() throws Exception {
		List cats = new ArrayList();
		this.conn = DBUtil.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from category");
		while (rs.next()) {
			Category cat = new Category();
			cat.setId(rs.getInt("id"));
			cat.setName(rs.getString("name"));
			cats.add(cat);
		}
		DBUtil.close(rs, st, conn);
		return cats;
	}

	// 根据分类编号查询歌曲
	public List findSongsByCatId(int catId) throws Exception {
		List songs = new ArrayList();
		this.conn = DBUtil.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from song where catid="
				+ catId);
		while (rs.next()) {
			Song song = new Song();
			song.setId(rs.getInt("id"));
			song.setName(rs.getString("name"));
			song.setSinger(rs.getString("singer"));
			song.setAlbum(rs.getString("album"));
			song.setCatld(rs.getInt("catId"));
			songs.add(song);
		}
		DBUtil.close(rs, st, conn);
		return songs;
	}
}

