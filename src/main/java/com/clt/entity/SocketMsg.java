package com.clt.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mrchen
 */
@Data
@Getter
@Setter
public class SocketMsg {
    private int type;

    private String fromUser;

    private String toUser;

    private String msg;

}

