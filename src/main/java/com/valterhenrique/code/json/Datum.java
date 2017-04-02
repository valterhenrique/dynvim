package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
		{"uri", "name", "description", "link", "duration", "width", "language", "height", "embed", "created_time",
				"modified_time", "release_time", "content_rating", "license", "privacy", "pictures", "tags", "stats",
				"metadata", "user", "app", "status", "resource_key", "embed_presets"})
public class Datum {

	@JsonProperty("uri")
	private String uri;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("link")
	private String link;
	@JsonProperty("duration")
	private Integer duration;
	@JsonProperty("width")
	private Integer width;
	@JsonProperty("language")
	private String language;
	@JsonProperty("height")
	private Integer height;
	@JsonProperty("embed")
	private Embed embed;
	@JsonProperty("created_time")
	private String createdTime;
	@JsonProperty("modified_time")
	private String modifiedTime;
	@JsonProperty("release_time")
	private String releaseTime;
	@JsonProperty("content_rating")
	private List<String> contentRating = null;
	@JsonProperty("license")
	private Object license;
	@JsonProperty("privacy")
	private Privacy privacy;
	@JsonProperty("pictures")
	private Pictures pictures;
	@JsonProperty("tags")
	private List<Tag> tags = null;
	@JsonProperty("stats")
	private Stats stats;
	@JsonProperty("metadata")
	private Metadata_ metadata;
	@JsonProperty("user")
	private User user;
	@JsonProperty("app")
	private Object app;
	@JsonProperty("status")
	private String status;
	@JsonProperty("resource_key")
	private String resourceKey;
	@JsonProperty("embed_presets")
	private Object embedPresets;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("uri")
	public String getUri() {
		return uri;
	}

	@JsonProperty("uri")
	public void setUri(String uri) {
		this.uri = uri;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("link")
	public String getLink() {
		return link;
	}

	@JsonProperty("link")
	public void setLink(String link) {
		this.link = link;
	}

	@JsonProperty("duration")
	public Integer getDuration() {
		return duration;
	}

	@JsonProperty("duration")
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@JsonProperty("width")
	public Integer getWidth() {
		return width;
	}

	@JsonProperty("width")
	public void setWidth(Integer width) {
		this.width = width;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("height")
	public Integer getHeight() {
		return height;
	}

	@JsonProperty("height")
	public void setHeight(Integer height) {
		this.height = height;
	}

	@JsonProperty("embed")
	public Embed getEmbed() {
		return embed;
	}

	@JsonProperty("embed")
	public void setEmbed(Embed embed) {
		this.embed = embed;
	}

	@JsonProperty("created_time")
	public String getCreatedTime() {
		return createdTime;
	}

	@JsonProperty("created_time")
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	@JsonProperty("modified_time")
	public String getModifiedTime() {
		return modifiedTime;
	}

	@JsonProperty("modified_time")
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@JsonProperty("release_time")
	public String getReleaseTime() {
		return releaseTime;
	}

	@JsonProperty("release_time")
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	@JsonProperty("content_rating")
	public List<String> getContentRating() {
		return contentRating;
	}

	@JsonProperty("content_rating")
	public void setContentRating(List<String> contentRating) {
		this.contentRating = contentRating;
	}

	@JsonProperty("license")
	public Object getLicense() {
		return license;
	}

	@JsonProperty("license")
	public void setLicense(Object license) {
		this.license = license;
	}

	@JsonProperty("privacy")
	public Privacy getPrivacy() {
		return privacy;
	}

	@JsonProperty("privacy")
	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}

	@JsonProperty("pictures")
	public Pictures getPictures() {
		return pictures;
	}

	@JsonProperty("pictures")
	public void setPictures(Pictures pictures) {
		this.pictures = pictures;
	}

	@JsonProperty("tags")
	public List<Tag> getTags() {
		return tags;
	}

	@JsonProperty("tags")
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@JsonProperty("stats")
	public Stats getStats() {
		return stats;
	}

	@JsonProperty("stats")
	public void setStats(Stats stats) {
		this.stats = stats;
	}

	@JsonProperty("metadata")
	public Metadata_ getMetadata() {
		return metadata;
	}

	@JsonProperty("metadata")
	public void setMetadata(Metadata_ metadata) {
		this.metadata = metadata;
	}

	@JsonProperty("user")
	public User getUser() {
		return user;
	}

	@JsonProperty("user")
	public void setUser(User user) {
		this.user = user;
	}

	@JsonProperty("app")
	public Object getApp() {
		return app;
	}

	@JsonProperty("app")
	public void setApp(Object app) {
		this.app = app;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("resource_key")
	public String getResourceKey() {
		return resourceKey;
	}

	@JsonProperty("resource_key")
	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey;
	}

	@JsonProperty("embed_presets")
	public Object getEmbedPresets() {
		return embedPresets;
	}

	@JsonProperty("embed_presets")
	public void setEmbedPresets(Object embedPresets) {
		this.embedPresets = embedPresets;
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
