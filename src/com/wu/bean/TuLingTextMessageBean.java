package com.wu.bean;

import java.util.List;
/**
 * 图灵机器人api格式bean
 * @author user
 *
 */
public class TuLingTextMessageBean {
	private String url;
	private int code;
	private String text;
	private List<ListEntity> list;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setList(List<ListEntity> list) {
		this.list = list;
	}

	public int getCode() {
		return code;
	}

	public String getText() {
		return text;
	}

	public List<ListEntity> getList() {
		return list;
	}

	public static class ListEntity {
		/**
		 * article : source : detailurl : icon :
		 */

		private String article;
		private String source;
		private String detailurl;
		private String icon;

		public void setArticle(String article) {
			this.article = article;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public void setDetailurl(String detailurl) {
			this.detailurl = detailurl;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getArticle() {
			return article;
		}

		public String getSource() {
			return source;
		}

		public String getDetailurl() {
			return detailurl;
		}

		public String getIcon() {
			return icon;
		}
	}
}
