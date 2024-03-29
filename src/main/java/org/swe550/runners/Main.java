package org.swe550.runners;

import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.graphwalker.websocket.WebSocketServer;
import org.swe550.modelimplementations.*;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Executor executor = new TestExecutor(
                TrendyolTest.class,
                SearchKeywordTest.class,
                ValidateSearchBarTest.class
        );

        WebSocketServer server = new WebSocketServer(8887, executor.getMachine());
        server.start();

        Result result = executor.execute(true);
        if (result.hasErrors()) {
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
        }
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
    }
}
