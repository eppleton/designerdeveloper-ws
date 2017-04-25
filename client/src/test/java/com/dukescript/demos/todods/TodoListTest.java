/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dukescript.demos.todods;

import net.java.html.junit.BrowserRunner;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 *
 * @author antonepple
 */
@RunWith(BrowserRunner.class)
public class TodoListTest {

    @Test
    public void testAddTask() {
        TaskListViewModel taskList = new TaskListViewModel();
        Assert.assertEquals(taskList.getTasks().size(), 0);
        taskList.setInput("Buy milk!");
        taskList.addTask();
        Assert.assertEquals(taskList.getTasks().size(), 1);
        Task task = taskList.getTasks().get(0);
        Assert.assertEquals(task.getTitle(), "Buy milk!");
    }

    @Test
    public void testDeleteTask() {
        TaskListViewModel taskListViewModel = new TaskListViewModel();
        taskListViewModel.getTasks().add(new Task("Buy milk!", false));
        taskListViewModel.getTasks().add(new Task("Buy more milk!", false));
        assertEquals(taskListViewModel.getTasks().size(), 2);
        Task toDelete = taskListViewModel.getTasks().get(1);
        taskListViewModel.deleteTask(toDelete);
        assertEquals(taskListViewModel.getTasks().size(), 1);
        assertEquals(taskListViewModel.getTasks().get(0).getTitle(), "Buy milk!");
    }

    @Test
    public void testStopEditing() {
        TaskListViewModel taskListViewModel = new TaskListViewModel();
        Task task = new Task("Buy milk!", false);
        taskListViewModel.setEditing(task);
        assertEquals(task, taskListViewModel.getEditing());
        taskListViewModel.stopEditing();
        Assert.assertNull(taskListViewModel.getEditing());
    }

    @Test
    public void testEditTask() {
        TaskListViewModel taskList = new TaskListViewModel();
        taskList.getTasks().add(new Task("Buy milk!", false));
        Assert.assertEquals(taskList.getTasks().size(), 1);
        Task task = taskList.getTasks().get(0);
        taskList.editTask(task);
        Task editing = taskList.getEditing();
        Assert.assertEquals(taskList.getTasks().get(0), editing);
        editing.setTitle("Buy more milk!");
        taskList.stopEditing();
        Task editing1 = taskList.getEditing();
        Assert.assertNull(editing1);
        Task edited = taskList.getTasks().get(0);
        Assert.assertEquals(edited.getTitle(), "Buy more milk!");
    }

}
