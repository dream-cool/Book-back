package com.clt.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author ：clt
 * @Date ：Created in 17:29 2020/03/01
 */
public class PageUtil{

    private PageUtil(){}

    public static PageInfo getPageInfo(Integer pageNum, Integer pageSize, List list){
        PageInfo pageInfo = new PageInfo<>();
        if (list.size() < pageSize){
            pageNum = 1;
        }
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(list.size());
        int fromIndex = ((pageNum -1) * pageSize);
        int toIndex = fromIndex + pageSize;
        toIndex = toIndex > list.size() ? list.size() : toIndex;
        pageInfo.setList(list.subList(fromIndex,toIndex));
        return pageInfo;
    }
}
