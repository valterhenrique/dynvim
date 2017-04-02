package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
		{"activities", "albums", "appearances", "categories", "channels", "feed", "followers", "following", "groups",
				"likes", "moderated_channels", "portfolios", "videos", "watchlater", "shared", "pictures"})
public class Connections__ {

	@JsonProperty("activities")
	private Activities activities;
	@JsonProperty("albums")
	private Albums albums;
	@JsonProperty("appearances")
	private Appearances appearances;
	@JsonProperty("categories")
	private Categories categories;
	@JsonProperty("channels")
	private Channels channels;
	@JsonProperty("feed")
	private Feed feed;
	@JsonProperty("followers")
	private Followers followers;
	@JsonProperty("following")
	private Following following;
	@JsonProperty("groups")
	private Groups groups;
	@JsonProperty("likes")
	private Likes_ likes;
	@JsonProperty("moderated_channels")
	private ModeratedChannels moderatedChannels;
	@JsonProperty("portfolios")
	private Portfolios portfolios;
	@JsonProperty("videos")
	private Videos_ videos;
	@JsonProperty("watchlater")
	private Watchlater watchlater;
	@JsonProperty("shared")
	private Shared shared;
	@JsonProperty("pictures")
	private Pictures___ pictures;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("activities")
	public Activities getActivities() {
		return activities;
	}

	@JsonProperty("activities")
	public void setActivities(Activities activities) {
		this.activities = activities;
	}

	@JsonProperty("albums")
	public Albums getAlbums() {
		return albums;
	}

	@JsonProperty("albums")
	public void setAlbums(Albums albums) {
		this.albums = albums;
	}

	@JsonProperty("appearances")
	public Appearances getAppearances() {
		return appearances;
	}

	@JsonProperty("appearances")
	public void setAppearances(Appearances appearances) {
		this.appearances = appearances;
	}

	@JsonProperty("categories")
	public Categories getCategories() {
		return categories;
	}

	@JsonProperty("categories")
	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@JsonProperty("channels")
	public Channels getChannels() {
		return channels;
	}

	@JsonProperty("channels")
	public void setChannels(Channels channels) {
		this.channels = channels;
	}

	@JsonProperty("feed")
	public Feed getFeed() {
		return feed;
	}

	@JsonProperty("feed")
	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	@JsonProperty("followers")
	public Followers getFollowers() {
		return followers;
	}

	@JsonProperty("followers")
	public void setFollowers(Followers followers) {
		this.followers = followers;
	}

	@JsonProperty("following")
	public Following getFollowing() {
		return following;
	}

	@JsonProperty("following")
	public void setFollowing(Following following) {
		this.following = following;
	}

	@JsonProperty("groups")
	public Groups getGroups() {
		return groups;
	}

	@JsonProperty("groups")
	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	@JsonProperty("likes")
	public Likes_ getLikes() {
		return likes;
	}

	@JsonProperty("likes")
	public void setLikes(Likes_ likes) {
		this.likes = likes;
	}

	@JsonProperty("moderated_channels")
	public ModeratedChannels getModeratedChannels() {
		return moderatedChannels;
	}

	@JsonProperty("moderated_channels")
	public void setModeratedChannels(ModeratedChannels moderatedChannels) {
		this.moderatedChannels = moderatedChannels;
	}

	@JsonProperty("portfolios")
	public Portfolios getPortfolios() {
		return portfolios;
	}

	@JsonProperty("portfolios")
	public void setPortfolios(Portfolios portfolios) {
		this.portfolios = portfolios;
	}

	@JsonProperty("videos")
	public Videos_ getVideos() {
		return videos;
	}

	@JsonProperty("videos")
	public void setVideos(Videos_ videos) {
		this.videos = videos;
	}

	@JsonProperty("watchlater")
	public Watchlater getWatchlater() {
		return watchlater;
	}

	@JsonProperty("watchlater")
	public void setWatchlater(Watchlater watchlater) {
		this.watchlater = watchlater;
	}

	@JsonProperty("shared")
	public Shared getShared() {
		return shared;
	}

	@JsonProperty("shared")
	public void setShared(Shared shared) {
		this.shared = shared;
	}

	@JsonProperty("pictures")
	public Pictures___ getPictures() {
		return pictures;
	}

	@JsonProperty("pictures")
	public void setPictures(Pictures___ pictures) {
		this.pictures = pictures;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
