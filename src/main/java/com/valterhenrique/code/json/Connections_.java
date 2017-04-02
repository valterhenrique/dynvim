package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"comments", "credits", "likes", "pictures", "texttracks", "related"})
public class Connections_ {

	@JsonProperty("comments")
	private Comments comments;
	@JsonProperty("credits")
	private Credits credits;
	@JsonProperty("likes")
	private Likes likes;
	@JsonProperty("pictures")
	private Pictures_ pictures;
	@JsonProperty("texttracks")
	private Texttracks texttracks;
	@JsonProperty("related")
	private Related related;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("comments")
	public Comments getComments() {
		return comments;
	}

	@JsonProperty("comments")
	public void setComments(Comments comments) {
		this.comments = comments;
	}

	@JsonProperty("credits")
	public Credits getCredits() {
		return credits;
	}

	@JsonProperty("credits")
	public void setCredits(Credits credits) {
		this.credits = credits;
	}

	@JsonProperty("likes")
	public Likes getLikes() {
		return likes;
	}

	@JsonProperty("likes")
	public void setLikes(Likes likes) {
		this.likes = likes;
	}

	@JsonProperty("pictures")
	public Pictures_ getPictures() {
		return pictures;
	}

	@JsonProperty("pictures")
	public void setPictures(Pictures_ pictures) {
		this.pictures = pictures;
	}

	@JsonProperty("texttracks")
	public Texttracks getTexttracks() {
		return texttracks;
	}

	@JsonProperty("texttracks")
	public void setTexttracks(Texttracks texttracks) {
		this.texttracks = texttracks;
	}

	@JsonProperty("related")
	public Related getRelated() {
		return related;
	}

	@JsonProperty("related")
	public void setRelated(Related related) {
		this.related = related;
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
