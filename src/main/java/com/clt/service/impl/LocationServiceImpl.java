package com.clt.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.clt.entity.Location;
import com.clt.dao.LocationDao;
import com.clt.entity.UserClass;
import com.clt.service.LocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Location)表服务实现类
 *
 * @author makejava
 * @since 2020-04-11 11:23:29
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService {
    @Resource
    private LocationDao locationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param locationId 主键
     * @return 实例对象
     */
    @Override
    public Location queryById(String locationId) {
        return this.locationDao.queryById(locationId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Location> queryAllByLimit(int offset, int limit) {
        return this.locationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param location 实例对象
     * @return 实例对象
     */
    @Override
    public Location insert(Location location) {
        final Location queryLocationResult = queryById(location.getLocationId());
        if (queryLocationResult != null){
            return null;
        }
        if (location != null && location.getLocationId() != null){
            final JSONArray locationArray = JSON.parseArray(location.getLocationId());
            if (locationArray != null && locationArray.size() == 4){
                location.setAreaNo(locationArray.get(0).toString());
                location.setFloorNo(locationArray.get(1).toString());
                location.setRoomNo(locationArray.get(2).toString());
                location.setBookshelfNo(locationArray.get(3).toString());
                Date now = new Date();
                location.setCreateTime(now);
                location.setUpdateTime(now);
            }
        } else {
            return null;
        }
        this.locationDao.insert(location);
        return location;
    }

    /**
     * 修改数据
     *
     * @param location 实例对象
     * @return 实例对象
     */
    @Override
    public Location update(Location location) {
        this.locationDao.update(location);
        return this.queryById(location.getLocationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param locationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String locationId) {
        return this.locationDao.deleteById(locationId) > 0;
    }
}