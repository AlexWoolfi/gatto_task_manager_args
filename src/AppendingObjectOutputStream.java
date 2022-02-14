import java.io.*;

public class AppendingObjectOutputStream extends ObjectOutputStream {
    private boolean append;
    private boolean initialized;
    private DataOutputStream dout;

    public AppendingObjectOutputStream(OutputStream out) throws IOException, IOException {
        super(out);
    }
    public AppendingObjectOutputStream(boolean append) throws IOException {
        super();
        this.append = append;
        this.initialized = true;
    }

    public AppendingObjectOutputStream(OutputStream out, boolean append) throws IOException {
        super(out);
        this.append = append;
        this.initialized = true;
        this.dout = new DataOutputStream(out);
        this.writeStreamHeader();
    }




    @Override
    protected void writeStreamHeader() throws IOException {
        if (!this.initialized || this.append) return;
        if (dout != null) {
            dout.writeShort(STREAM_MAGIC);
            dout.writeShort(STREAM_VERSION);
//            reset();
        }
    }
    public static ObjectOutputStream createStream(File userList) throws IOException {
        return userList.exists()
                ? new AppendingObjectOutputStream(new FileOutputStream(userList, true))
                : new ObjectOutputStream(new FileOutputStream(userList, true));
    }
}
