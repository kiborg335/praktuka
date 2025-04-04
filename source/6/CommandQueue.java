package ex05;

import java.util.Vector;
import ex04.Command;

public class CommandQueue implements Queue {
    private Vector<Command> tasks;
    private boolean waiting;
    private boolean shutdown;

    public CommandQueue() {
        tasks = new Vector<>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return tasks.remove(0);
    }

    private class Worker implements Runnable {
        public void run() {
            while (!shutdown) {
                Command r = take();
                r.execute();
            }
        }
    }
}