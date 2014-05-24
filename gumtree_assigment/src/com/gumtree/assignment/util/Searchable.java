package com.gumtree.assignment.util;

import com.gumtree.assignment.util.SearchCriteria;

import java.util.List;

/**
 * Created by Dilyan B. on 14-5-24.
 */
public interface Searchable {

    public List<Object> find(SearchCriteria... searchCriteria);
}
