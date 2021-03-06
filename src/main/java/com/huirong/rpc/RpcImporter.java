package com.huirong.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by huirong on 17-3-12.
 * 本地代理
 */
public class RpcImporter <S>{
    public S importer(final Class<?> serverClass, final InetSocketAddress address){
        return (S) Proxy.newProxyInstance(serverClass.getClassLoader(), new Class<?>[]{
                serverClass.getInterfaces()[0]}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = null;
                ObjectOutputStream output = null;
                ObjectInputStream input = null;
                try {
                    socket = new Socket();
                    socket.connect(address);
                    output = new ObjectOutputStream(socket.getOutputStream());
                    output.writeUTF(serverClass.getName());
                    output.writeUTF(method.getName());
                    output.writeObject(method.getParameterTypes());
                    output.writeObject(args);
                    input = new ObjectInputStream(socket.getInputStream());
                    return input.readObject();
                }finally {
                    if (socket != null){
                        socket.close();
                    }
                    if (output != null){
                        output.close();
                    }
                    if (input != null){
                        input.close();
                    }
                }
            }
        });
    }
}
