package com.yxw.modules.mybatis2.pojo;

import java.util.List;

/**
 * Created by Yan on 2018/8/2.
 */
public class QueryVo {
    private User user;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
