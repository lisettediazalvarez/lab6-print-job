class PrintJob {
    private String documentName;
    private int pageCount;

    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages" + pageCount + "]";
    }
}