package org.guerillamac.services;

import org.guerillamac.data.NewsFeed;

public interface NewsFeedService {
	NewsFeed getNewsFeed(String countryName);
}
