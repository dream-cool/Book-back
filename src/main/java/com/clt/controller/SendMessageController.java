package com.clt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.clt.entity.Email;
import com.clt.entity.Message;
import com.clt.entity.User;
import com.clt.entity.UserClass;
import com.clt.service.MessageService;
import com.clt.service.UserService;
import com.clt.utils.DateUtils;
import com.clt.utils.MailUtil;
import com.clt.utils.ResultUtil;
import com.clt.utils.UUIDUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author ：clt
 * @Date ：Created in 14:47 2020/04/12
 */
@RestController
@RequestMapping("sendMessage")
public class SendMessageController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private MailUtil mailUtil;

    @GetMapping
    @ApiOperation("")
    public ResultUtil<Boolean> sendMessage(
            @ApiParam("singleSend") @RequestParam("singleSend") Boolean singleSend,
            @ApiParam("receivers") @RequestParam("receivers") String receivers,
            @ApiParam("messageContent") @RequestParam("messageContent") String  messageContent,
            @ApiParam("sendAccount") @RequestParam(value = "sendAccount", required = false) Boolean sendAccount,
            @ApiParam("sendEmail") @RequestParam(value = "sendEmail", required = false) Boolean sendEmail,
            @ApiParam("sender") @RequestParam("sender") String sender,
            @ApiParam("sendTime") @RequestParam(value = "sendTime", required = false) String sendTime
    ){
        if (messageContent == null || StringUtils.isEmpty(messageContent)){
            return ResultUtil.failed("操作失败，消息内容不能为空");
        }
        if (sender == null || StringUtils.isEmpty(sender)){
            return ResultUtil.failed("操作失败，发送人不能为空");
        }
        if (sendTime != null){
            final Date sendTimeDate = DateUtils.stringTimeToStandardTime(sendTime);
            if ( sendTimeDate != null && sendTimeDate.getTime() - System.currentTimeMillis()  < 60000){
                return ResultUtil.failed("操作失败，发送时间不能早于系统时间");
            }
        }

        sendAccount = sendAccount == null ? true : sendAccount;
        sendEmail = sendEmail == null ? true : sendEmail;

        Set<User> users = new HashSet<>();

        if (singleSend){
            final User userResult = userService.queryByUserName(receivers);
            if (userResult == null){
                return ResultUtil.failed("操作失败，没有找到对应用户");
            }
            if (sendTime == null){
                users.add(userResult);
                send(users, messageContent , sender, sendEmail, sendAccount);
            }
            return ResultUtil.success(null,"操作成功");
        }

        final JSONArray classList = JSON.parseArray(receivers);
        if (classList == null || classList.size() == 0){
            return ResultUtil.failed("操作失败，接收信息群体不能为空");
        }
        List<UserClass> classes = new ArrayList<>(classList.size());
        classList.stream().forEach(classInfo -> {
            final JSONArray classArrayObject = JSON.parseArray(classInfo.toString());
            UserClass userClass = new UserClass();
            if (classArrayObject != null){
                for (int i = 0; i < classArrayObject.size(); i++) {
                    if (i == 0){
                        userClass.setGradeNo(classArrayObject.get(0).toString());
                    }
                    if (i == 1){
                        userClass.setDepartNo(classArrayObject.get(1).toString());
                    }
                    if (i == 2){
                        userClass.setMajorNo(classArrayObject.get(2).toString());
                    }
                    if (i == 3){
                        userClass.setClassNumberNo(classArrayObject.get(3).toString());
                    }
                }
                classes.add(userClass);
            }
        });

        classes.stream().forEach(classCondition ->{
            users.addAll(userService.queryByClass(classCondition));
        });
        if (sendTime == null){
            send(users, messageContent , sender, sendEmail, sendAccount);
        }
        return ResultUtil.success(null,"操作成功");
    }

    @Async
    public void send(Set<User> receiver, String messageContent, String sender,
                     Boolean sendEmail, Boolean sendAccount){
        receiver.stream().forEach(user -> {
            if (sendAccount){
                Message message = new Message();
                message.setMessageId(UUIDUtil.getUUID());
                message.setSendingTime(new Date());
                message.setContent(messageContent);
                message.setStatus(0);
                message.setSendUserId(sender);
                message.setUserId(user.getUserId());
                messageService.insert(message);
            }
            if (sendEmail && user.getEmail() != null){
                mailUtil.sendSimpleMail(new Email(user.getEmail(), "励新图书系统消息", messageContent));
            }
        });
    }
}
