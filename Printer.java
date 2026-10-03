
public class Printer {
    private Queue jobQueue;

    public Printer() {
        jobQueue = new LinkedQueue();
    }
    public void addJob(PrintJob job) {
        System.out.println("Adding to Queue: " + job);
        jobQueue.enqueue(job);
    }
    public void processNextJob() {
        if(jobQueue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            PrintJob job = (PrintJob) jobQueue.dequeue();
            System.out.println("Processing..." + job);
        }
    }
    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to print ---");
        officePrinter.processNextJob();
        officePrinter.processNextJob();

        System.out.println("\n--- New high-priority job arriving ---");
        officePrinter.addJob(new PrintJob("Urgent_memo.pdf", 1));

        officePrinter.processNextJob();
        officePrinter.processNextJob();
        officePrinter.processNextJob();
    }
}
interface Queue {
    void enqueue(Object item);
    Object dequeue();
    boolean isEmpty();
}
class LinkedQueue implements Queue {
    private Node front;
    private Node rear;

    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    public void enqueue(Object item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode; 
        }
    }

    public Object dequeue() {
        if (front == null) {
            return null;
        }
        Object item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    public boolean isEmpty() {
        return front == null;
    }
}