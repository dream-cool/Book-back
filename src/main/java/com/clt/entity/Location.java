package com.clt.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Location)实体类
 *
 * @author makejava
 * @since 2020-04-11 11:23:29
 */
public class Location implements Serializable {
    private static final long serialVersionUID = 111700316994244713L;
    /**
    * 位置id
    */
    private String locationId;
    /**
    * 楼区编号
    */
    private String areaNo;
    /**
    * 楼层编号
    */
    private String floorNo;
    /**
    * 房间编号
    */
    private String roomNo;
    /**
    * 书架编号
    */
    private String bookshelfNo;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 备用字段
    */
    private String remark1;
    
    private String remark2;
    
    private String remark3;
    
    private String remark4;


    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getBookshelfNo() {
        return bookshelfNo;
    }

    public void setBookshelfNo(String bookshelfNo) {
        this.bookshelfNo = bookshelfNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

}