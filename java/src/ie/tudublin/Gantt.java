package ie.tudublin;

import processing.core.PApplet;
//import array list 
import java.util.ArrayList;



import processing.data.*;

public class Gantt extends PApplet
{	
	//ARRAY LIST TO HOLD INSTANCES OF THE TASK CLASS
	ArrayList<Task> tasks = new ArrayList<Task>();

	private int maxMonths = 30;
	float namePart = 150;
	private float border = 40;
	private float rowHeight = 40;
	
	public void settings()
	{
		size(800, 600);
		//calls loadTasks and printTasks
		loadTasks();
		printTasks();
	}


	//populates the ArrayList from the file tasks.csv
	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");

		for (TableRow row:table.rows())
		{
			Task task = new Task(row);
			tasks.add(task);
		} 
		
	}

	public void printTasks()
	{
		// prints the elements of the ArrayList.
		for (Task t:tasks)
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
		//hsb colour
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}

	void displayTasks() {
		textSize(14);
		textAlign(LEFT, CENTER);

		textAlign(CENTER, CENTER);
		stroke(128);


		//
		for (int i = 1; i <= maxMonths; i++) 
		{
			float x = map(i, 1, maxMonths, namePart, width - border);
			line(x, border, x, height - border);
			fill(255);
			text(i, x, border * 0.5f);
		}

		textAlign(LEFT, CENTER);
		for (int i = 0; i < tasks.size(); i++)
		{
			float y = border + border + rowHeight * i;
			fill(255);
			text(tasks.get(i).getName(), border, y);

			noStroke();
			fill(map(i, 0, tasks.size(), 0, 255), 255, 255);
			float x1 = map(tasks.get(i).getStart(), 1, maxMonths, namePart, width - border);
			float x2 = map(tasks.get(i).getStart(), 1, maxMonths, namePart, width - border);
			rect(x1, y - 15, x2 - x1, rowHeight - 5, 5.0f);


		}

	}

}
