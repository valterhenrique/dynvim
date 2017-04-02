package com.valterhenrique.code.processing;

public class VimeoViewsResult {

	// TODO "any other metadata you think is appropriate", so maybe add some more fields here for additional data
	private final String searchTerm;
	private final Long views;
	private boolean executedSuccessfully;

	private VimeoViewsResult(String searchTerm, Long views, boolean executedSuccessfully) {
		this.searchTerm = searchTerm;
		this.views = views;
		this.executedSuccessfully = executedSuccessfully;
	}

	static VimeoViewsResult of(String searchTerm, Long views) {
		return new VimeoViewsResult(searchTerm, views, true);
	}

	static VimeoViewsResult error(String searchTerm) {
		return new VimeoViewsResult(searchTerm, null, false);
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public Long getViews() {
		return views;
	}

	public boolean isExecutedSuccessfully() {
		return executedSuccessfully;
	}

	@Override
	public String toString() {
		return "VimeoViewsResult{" + "searchTerm='" + searchTerm + '\'' + ", views=" + views + ", executedSuccessfully="
				+ executedSuccessfully + '}';
	}

}
