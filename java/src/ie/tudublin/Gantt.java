package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);
	}

	void displayTasks()
	{

		float border = 0.1f * width;
        textAlign(RIGHT);

		for(int i = 1 ; i <=30 ; i ++)
        {
			float x = map(i, 1, 30, border*2, width - border);
			float y = map(i, 1, 30, border*2, width - border);

			fill(255);
			text(i, x, border / 2);
			text(i, y, border / 2);

			stroke(255);
			line(x, border,x, height - border);
		}

		
		for(int i = 0 ; i < tasks.size(); i++)
        {
			float x = map(i, 0, 7, border, border);
			float y = map(i, 0, 7, border * 2, height - 200);

			Task t = tasks.get(i);

			fill(255);
			text(t.getTask(), x, y);
			
		}
		
			

	}

	

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
        for(TableRow row:table.rows())
        {
            Task t = new Task(row);
            tasks.add(t);
        }
		
	}

	public void printTasks()
	{
		for(Task t: tasks)
        {
            println(t);
        }
		
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		colorMode(HSB);
		loadTasks();
		printTasks();
		
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
		//printTasks();

	}
}
