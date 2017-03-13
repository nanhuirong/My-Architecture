package com.huirong.rpc;

/**
 * Created by huirong on 17-3-12.
 * 服务提供者
 */
public class EchoServiceImpl implements EchoService{
    @Override
    public String echo(String ping) {
        return ping != null ? ping + "--> I am ok." : "I am OK";
    }
}
