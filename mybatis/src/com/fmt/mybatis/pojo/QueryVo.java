package com.fmt.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 否命题 on 2017/7/13.
 */
public class QueryVo implements Serializable{

    private static final long serialVersionUID=1l;

    private User user;

    private List<Integer>  list_ids;
    private Integer[]     ids;

    public List<Integer> getList_ids() {
        return list_ids;
    }

    public void setList_ids(List<Integer> list_ids) {
        this.list_ids = list_ids;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
