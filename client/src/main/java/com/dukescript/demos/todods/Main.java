package com.dukescript.demos.todods;

import net.java.html.boot.BrowserBuilder;

public final class Main {

    private Main() {
    }

    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
                loadPage("pages/index_1.html").
                loadClass(Main.class).
                invoke("onPageLoad", args).
                showAndWait();
        System.exit(0);
    }

    /**
     * Called when the page is ready.
     */
    public static void onPageLoad() {
        TaskListViewModel taskList;
        taskList = new TaskListViewModel();
        taskList.getTasks().add(new Task("Buy milk", Boolean.TRUE));
        taskList.applyBindings();
    }

}