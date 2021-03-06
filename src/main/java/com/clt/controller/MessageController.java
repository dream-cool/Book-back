package com.clt.controller;

import com.clt.constant.Const;
import com.clt.entity.Message;
import com.clt.service.MessageService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Message)表控制层
 *
 * @author makejava
 * @since 2020-02-26 09:36:02
 */
@RestController
@RequestMapping("message")
@Api("信息接口")
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
    /**
     * 服务对象
     */
    @Resource
    private MessageService messageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<Message> selectOne(
            @ApiParam("id")
            @PathVariable String id) {
        Message message = this.messageService.queryById(id);
        if (message != null) {
            return ResultUtil.success(message);
        } else {
            return ResultUtil.failed("没有找到对应信息");
        }
    }

    /**
     * 分页查询数据
     *
     * @param pageNum  起始
     * @param pageSize 条数
     * @return 多条数据
     */
    @GetMapping("")
    @ApiOperation("分页查询数据")
    public ResultUtil<PageInfo<Message>> selectAllByLimit(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            Message message
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<Message> messages = this.messageService.queryAllByCondition(message);
        PageInfo<Message> pageInfo = new PageInfo<>(page);
        if (pageInfo != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param message 信息实体
     * @return 新增的数据
     */
    @PostMapping("")
    @ApiOperation("新增单条数据")
    public ResultUtil<Message> insert(@RequestBody Message message) {
        Message insertMessage = this.messageService.insert(message);
        if (insertMessage != null) {
            return ResultUtil.success(insertMessage, "新增成功");
        } else {
            return ResultUtil.failed("新增失败");
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param message 信息实体
     * @return 更新的数据
     */
    @PutMapping("")
    @ApiOperation("更新单条数据")
    public ResultUtil<Message> update(@RequestBody Message message) {
        if (this.messageService.queryById(message.getMessageId()) == null) {
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        Message updateMessage = this.messageService.update(message);
        if (updateMessage != null) {
            return ResultUtil.success(updateMessage, "修改成功");
        } else {
            return ResultUtil.failed("修改失败");
        }
    }

    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除单条数据")
    public ResultUtil<Boolean> delete(@PathVariable String id) {
        if (this.messageService.queryById(id) == null) {
            return ResultUtil.failed("删除失败，没有找到对应信息");
        }
        boolean flag = this.messageService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed("删除失败");
        }
    }


    /**
     * 修改某个用户的消息状态
     *
     * @param userId 用户id
     * @return 修改条数
     */
    @PutMapping("/readMessage/{userId}")
    @ApiOperation("删除单条数据")
    public ResultUtil<Integer> readMessageByUser(@PathVariable String userId) {
        if (userId == null || StringUtils.isEmpty(userId)){
            ResultUtil.failed("修改的用户对象为空");
        }
        int result = this.messageService.readMessageByUser(userId);
        return ResultUtil.success(result, "消息已读");
    }

    @GetMapping("/unreadMessageCount/{userName}")
    @ApiOperation("获取用户未读的消息数量")
    public ResultUtil<Long> getUnreadMessageCount(@PathVariable String userName) {
        return ResultUtil.success(messageService.queryUnreadMessageCountByUserName(userName + Const.MESSAGE_SUFFIX));
    }

    @GetMapping("/consumeUnreadMessage/{userName}")
    @ApiOperation("消费用户未读的消息")
    public ResultUtil<List<Message>> consumeUnreadMessageByUserName(@PathVariable String userName) {
        return ResultUtil.success(messageService.consumeUnreadMessageByUserName(userName + Const.MESSAGE_SUFFIX));
    }

}