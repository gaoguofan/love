package com.bkn.system.dto;

import java.util.List;

/**
 * 用于群发消息,图文消息模板
* @author 李志伟
* @date 2015年8月11日 上午12:05:21
 */
public class ArticlesDto {
    /**
     *图文消息集合
     */
	private List<ThumbDto> articles;

	public List<ThumbDto> getArticles() {
		return articles;
	}

	public void setArticles(List<ThumbDto> articles) {
		this.articles = articles;
	}
}
