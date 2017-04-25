package com.dukescript.demos.todods;

import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.ModelOperation;
import net.java.html.json.Property;

@Model(className = "TaskListViewModel", properties = {
    @Property(name = "input", type = String.class),
    @Property(name = "tasks", type = Task.class, array = true),
    @Property(name = "editing", type = Task.class)
}, targetId = "body")
final class TaskListViewModelDefinition {

    @Function
    @ModelOperation
    public static void editTask(TaskListViewModel list, Task data) {
    }

    @Function
    @ModelOperation
    public static void stopEditing(TaskListViewModel list) {
    }

    @Function
    @ModelOperation
    public static void deleteTask(TaskListViewModel model, Task data) {
    }

    @Function
    @ModelOperation
    public static void addTask(TaskListViewModel model) {
    }

}
