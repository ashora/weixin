package com.wu.utils;
/**
 * 图灵机器人消息类型
 * @author user
 *
 */
public class TuLingMessageUtils {

	public static final int CODE_TEXT=100000;//文本消息
	public static final int CODE_TRAIN=305000;//列车消息
	public static final int CODE_URL=200000;//网址类数据
	public static final int CODE_NEWS=302000;//新闻
	public static final int CODE_OTHER=308000;//菜谱，视频，小说
	public static final int CODE_ERROR_KEY_LENGTH=40001;//key的长度错误
	public static final int CODE_ERROR_NOTHING=40002;//请求内容为空
	public static final int CODE_ERROR_KEY=40003;//key错误，或者账号未激活
	public static final int CODE_ERROR_NUM=40004;//当天的请求次数用完
	public static final int CODE_ERROR=40005;//暂不支持该功能
	public static final int CODE_ERROR_SERVER_UPDATE=40006;//服务器升级
	public static final int CODE_ERROR_SERVER_DATA=40007;//服务器数据格式异常
	
	
}
