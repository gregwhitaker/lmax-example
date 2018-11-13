package lmax.example.handler;

import com.lmax.disruptor.EventHandler;
import lmax.example.event.HelloEvent;

public class HelloEventHandler implements EventHandler<HelloEvent> {

    @Override
    public void onEvent(HelloEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(String.format("Hello, %s!", event.getName()));
    }
}
