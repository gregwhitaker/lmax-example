package lmax.example;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import lmax.example.event.HelloEvent;
import lmax.example.handler.GoodbyeEventHandler;
import lmax.example.handler.HelloEventHandler;

public class Main {

    public static void main(String... args) throws Exception {

        Disruptor<HelloEvent> disruptor = new Disruptor<HelloEvent>(HelloEvent.EVENT_FACTORY,
                1024, DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new BusySpinWaitStrategy());

        disruptor.handleEventsWith(new HelloEventHandler(), new GoodbyeEventHandler());

        RingBuffer<HelloEvent> ringBuffer = disruptor.start();

        for (int i = 1; i <= 100; i++) {
            long seqId = ringBuffer.next();

            HelloEvent event = ringBuffer.get(seqId);
            event.setName("Test" + i);

            ringBuffer.publish(seqId);
        }

        Thread.currentThread().join();
    }
}
