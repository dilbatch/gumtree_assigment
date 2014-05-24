package com.gumtree.assignment.util;

import java.util.List;

/**
 * Created by Dilyan B. on 14-5-24.
 */
public interface Orderable {
    public final static int ASC = 0;
    public final static int DESC =1;

    public void orderBy(OrderCriteria orderCriteria);
}
