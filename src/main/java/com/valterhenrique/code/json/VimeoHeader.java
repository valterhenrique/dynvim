package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"X-Cache", "Server", "Connection", "X-RateLimit-Reset", "Date", "Via", "X-Timer", "Accept-Ranges",
						   "Fastly-Debug-Digest", "Strict-Transport-Security", "X-RateLimit-Remaining", "Cache-Control",
						   "X-Served-By", "Vary", "X-RateLimit-Limit", "Expires", "X-Cache-Hits", "Content-Type"})
public class VimeoHeader {

	@JsonProperty("X-Cache")
	private String xCache;
	@JsonProperty("Server")
	private String server;
	@JsonProperty("Connection")
	private String connection;
	@JsonProperty("X-RateLimit-Reset")
	private String xRateLimitReset;
	@JsonProperty("Date")
	private String date;
	@JsonProperty("Via")
	private String via;
	@JsonProperty("X-Timer")
	private String xTimer;
	@JsonProperty("Accept-Ranges")
	private String acceptRanges;
	@JsonProperty("Fastly-Debug-Digest")
	private String fastlyDebugDigest;
	@JsonProperty("Strict-Transport-Security")
	private String strictTransportSecurity;
	@JsonProperty("X-RateLimit-Remaining")
	private String xRateLimitRemaining;
	@JsonProperty("Cache-Control")
	private String cacheControl;
	@JsonProperty("X-Served-By")
	private String xServedBy;
	@JsonProperty("Vary")
	private String vary;
	@JsonProperty("X-RateLimit-Limit")
	private String xRateLimitLimit;
	@JsonProperty("Expires")
	private String expires;
	@JsonProperty("X-Cache-Hits")
	private String xCacheHits;
	@JsonProperty("Content-Type")
	private String contentType;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("X-Cache")
	public String getXCache() {
		return xCache;
	}

	@JsonProperty("X-Cache")
	public void setXCache(String xCache) {
		this.xCache = xCache;
	}

	@JsonProperty("Server")
	public String getServer() {
		return server;
	}

	@JsonProperty("Server")
	public void setServer(String server) {
		this.server = server;
	}

	@JsonProperty("Connection")
	public String getConnection() {
		return connection;
	}

	@JsonProperty("Connection")
	public void setConnection(String connection) {
		this.connection = connection;
	}

	@JsonProperty("X-RateLimit-Reset")
	public String getXRateLimitReset() {
		return xRateLimitReset;
	}

	@JsonProperty("X-RateLimit-Reset")
	public void setXRateLimitReset(String xRateLimitReset) {
		this.xRateLimitReset = xRateLimitReset;
	}

	@JsonProperty("Date")
	public String getDate() {
		return date;
	}

	@JsonProperty("Date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("Via")
	public String getVia() {
		return via;
	}

	@JsonProperty("Via")
	public void setVia(String via) {
		this.via = via;
	}

	@JsonProperty("X-Timer")
	public String getXTimer() {
		return xTimer;
	}

	@JsonProperty("X-Timer")
	public void setXTimer(String xTimer) {
		this.xTimer = xTimer;
	}

	@JsonProperty("Accept-Ranges")
	public String getAcceptRanges() {
		return acceptRanges;
	}

	@JsonProperty("Accept-Ranges")
	public void setAcceptRanges(String acceptRanges) {
		this.acceptRanges = acceptRanges;
	}

	@JsonProperty("Fastly-Debug-Digest")
	public String getFastlyDebugDigest() {
		return fastlyDebugDigest;
	}

	@JsonProperty("Fastly-Debug-Digest")
	public void setFastlyDebugDigest(String fastlyDebugDigest) {
		this.fastlyDebugDigest = fastlyDebugDigest;
	}

	@JsonProperty("Strict-Transport-Security")
	public String getStrictTransportSecurity() {
		return strictTransportSecurity;
	}

	@JsonProperty("Strict-Transport-Security")
	public void setStrictTransportSecurity(String strictTransportSecurity) {
		this.strictTransportSecurity = strictTransportSecurity;
	}

	@JsonProperty("X-RateLimit-Remaining")
	public String getXRateLimitRemaining() {
		return xRateLimitRemaining;
	}

	@JsonProperty("X-RateLimit-Remaining")
	public void setXRateLimitRemaining(String xRateLimitRemaining) {
		this.xRateLimitRemaining = xRateLimitRemaining;
	}

	@JsonProperty("Cache-Control")
	public String getCacheControl() {
		return cacheControl;
	}

	@JsonProperty("Cache-Control")
	public void setCacheControl(String cacheControl) {
		this.cacheControl = cacheControl;
	}

	@JsonProperty("X-Served-By")
	public String getXServedBy() {
		return xServedBy;
	}

	@JsonProperty("X-Served-By")
	public void setXServedBy(String xServedBy) {
		this.xServedBy = xServedBy;
	}

	@JsonProperty("Vary")
	public String getVary() {
		return vary;
	}

	@JsonProperty("Vary")
	public void setVary(String vary) {
		this.vary = vary;
	}

	@JsonProperty("X-RateLimit-Limit")
	public String getXRateLimitLimit() {
		return xRateLimitLimit;
	}

	@JsonProperty("X-RateLimit-Limit")
	public void setXRateLimitLimit(String xRateLimitLimit) {
		this.xRateLimitLimit = xRateLimitLimit;
	}

	@JsonProperty("Expires")
	public String getExpires() {
		return expires;
	}

	@JsonProperty("Expires")
	public void setExpires(String expires) {
		this.expires = expires;
	}

	@JsonProperty("X-Cache-Hits")
	public String getXCacheHits() {
		return xCacheHits;
	}

	@JsonProperty("X-Cache-Hits")
	public void setXCacheHits(String xCacheHits) {
		this.xCacheHits = xCacheHits;
	}

	@JsonProperty("Content-Type")
	public String getContentType() {
		return contentType;
	}

	@JsonProperty("Content-Type")
	public void setContentType(String contentType) {
		this.contentType = contentType;
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

