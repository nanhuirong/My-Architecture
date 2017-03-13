package com.huirong.rpc;

import java.net.InetSocketAddress;

/**
 * Created by huirong on 17-3-12.
 */
public class RpcTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 9999);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost",9999));
        System.out.println(echo.echo("Are you ok?"));

    }
}
