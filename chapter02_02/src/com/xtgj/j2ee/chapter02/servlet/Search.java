package com.xtgj.j2ee.chapter02.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtgj.j2ee.chapter02.entity.Song;
import com.xtgj.j2ee.chapter02.user.biz.Business;

public class Search extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		
		int catId = Integer.parseInt(request.getParameter("catId"));
		Business bo = new Business();
		
		List songs = null;
		try{
			//查询数据库获取歌曲详细信息的集合
			songs = bo.findSongsByCatId(catId);
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException("数据库连接有错");
			
		}
		//将歌曲信息组织成XML格式
		StringBuffer xml = new StringBuffer("<songs>");
		for(int i=0;i<songs.size();i++){
			Song song = (Song)songs.get(i);
			xml.append("<song>")
				.append("<id>"+song.getId()+"</id>")
				.append("<name>"+song.getName()+"</name>")
				.append("<singer>"+song.getSinger()+"</singer>")
				.append("<album>"+song.getAlbum()+"</album>")
				.append("<catId>"+song.getCatld()+"</catId>")
				.append("</song>");
		}
		xml.append("</songs>");
		
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out=response.getWriter();
		//发送XML数据
		out.println(xml.toString());
		out.close();
    }
}
