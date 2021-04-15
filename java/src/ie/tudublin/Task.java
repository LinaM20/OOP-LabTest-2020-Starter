package ie.tudublin;

import processing.data.TableRow;

public class Task {

    //private fields
    private String name;
    private int start;
    private int end;

    //public accessor methods
    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart() {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd() {
        this.end = end;
    }

    public Task(String name, int start, int end)
    {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    //constructor method to take processing tablerow as a parameter
    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    @Override
    public String toString() {
        return "Task [end =" + end + ", name=" + " , start=" + start + "]";
    }


}

