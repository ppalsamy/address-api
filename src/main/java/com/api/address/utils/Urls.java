package com.api.address.utils;

public interface Urls {

	public static final String ADDRESS = "/address";
	public static final String ADDRESS_BY_ID=ADDRESS+"/{ID}";
	public static final String ADDRESS_SEARCH_ZIP_CITY_STATE = ADDRESS+"/{zipOrCityOrState}";
}
