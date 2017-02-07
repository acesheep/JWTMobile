package com.zondy.jwt.jwtmobile.view;

import com.zondy.jwt.jwtmobile.entity.EntitySearchResult;

import java.util.List;

/**
 * Created by sheep on 2017/1/19.
 */

public interface ISearchZHCXListView {
    void queryZHCXListSuccessed(List<EntitySearchResult> searchResults);
    void queryZHCXListUnSuccessed(String msg);
}
