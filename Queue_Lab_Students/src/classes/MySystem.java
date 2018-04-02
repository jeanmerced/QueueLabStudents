package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MySystem {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Read input data and place relevant data for each job in a queue
		Scanner jobTimes = new Scanner(new File("input.txt")).useDelimiter("\\D");
		
		SLLQueue<Job> inputQueue = new SLLQueue<>();
		
		int pid = 1;
		while(jobTimes.hasNext()) {
			Job newJob = new Job(pid, jobTimes.nextInt(), jobTimes.nextInt());
			inputQueue.enqueue(newJob);
			pid++;
		}
		jobTimes.close();
		
		// Initialize another queue of jobs as an empty queue
		ArrayQueue<Job> processingQueue = new ArrayQueue<>();
		
		// Create an empty list of terminated jobs
		ArrayList<Job> terminatedJobs = new ArrayList<>();
		
		// Set time
		int t = 0;
		
		// Complete tasks
		while(!(inputQueue.isEmpty()) || !(processingQueue.isEmpty())) {
			if(!(processingQueue.isEmpty())) {
				processingQueue.first().isServed(1);
				if(processingQueue.first().getRemainingTime() == 0) {
					processingQueue.first().setDepartureTime(t);
					terminatedJobs.add(processingQueue.dequeue()); 
				}
				else
					processingQueue.enqueue(processingQueue.dequeue());
			}
			if(!(inputQueue.isEmpty()) && inputQueue.first().getArrivalTime() == t)
				processingQueue.enqueue(inputQueue.dequeue());
			t++;	
		}
		
		// Compute final statistics
		double average = 0;
		for(Job j : terminatedJobs) {
			int totalTime = j.getDepartureTime() - j.getArrivalTime();
			average += totalTime;
		}
		average = average / terminatedJobs.size();
		
		System.out.println("Average Time in System is: " + average);
	}
}
