import java.io.*;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {

        //1. 创建 selector
        Selector selector = Selector.open();

        //2. 创建 socketChannel,并注册到 selector 上
        ServerSocketChannel channel = ServerSocketChannel.open();

        channel.register(selector , SelectionKey.OP_ACCEPT);

        while (true){
            //3. 监听事件,一直阻塞直到 至少有一个事件到达
            int num = selector.select();

            // 4. 处理监听事件
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()){
                    // accept 请求
                }else if (key.isReadable()){
                    // 可读事件
                }
                keyIterator.remove();
            }
        }

    }
}
