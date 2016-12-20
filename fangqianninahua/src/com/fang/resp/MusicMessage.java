package com.fang.resp;

/**
 * 音乐消息
 * 
 * @author V3芳
 * @author 2015年1月27日
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}