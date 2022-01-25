import org.apache.lucene.store.*;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EnhancedDirectory extends BaseDirectory {

    private ByteBuffersDirectory delegate = new ByteBuffersDirectory();
    private ConcurrentHashMap<String, IndexInput> indexInputMap = new ConcurrentHashMap<String, IndexInput>();
    private ConcurrentHashMap<String, IndexOutput> indexOutputMap = new ConcurrentHashMap<String, IndexOutput>();

    public EnhancedDirectory() {
        super(new SingleInstanceLockFactory());
    }

    @Override
    public String[] listAll() throws IOException {
        return delegate.listAll();
    }

    @Override
    public void deleteFile(String name) throws IOException {
        delegate.deleteFile(name);
    }

    @Override
    public long fileLength(String name) throws IOException {
        return delegate.fileLength(name);
    }

    @Override
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
        IndexOutput result = delegate.createOutput(name, context);
        indexOutputMap.put(name, result);
        return result;
    }

    @Override
    public IndexOutput createTempOutput(String prefix, String suffix, IOContext context) throws IOException {
        IndexOutput result = delegate.createTempOutput(prefix, suffix, context);
        return result;
    }

    @Override
    public void sync(Collection<String> names) throws IOException {
        delegate.sync(names);
    }

    @Override
    public void syncMetaData() throws IOException {
        delegate.syncMetaData();
    }

    @Override
    public void rename(String source, String dest) throws IOException {
        delegate.rename(source, dest);
    }

    @Override
    public IndexInput openInput(String name, IOContext context) throws IOException {
        IndexInput result = delegate.openInput(name, context);
        indexInputMap.put(name, result);
        System.out.println("Opening : " + result.toString());
        return result;
    }

    @Override
    public void close() throws IOException {
        delegate.close();
    }

    @Override
    public Set<String> getPendingDeletions() throws IOException {
        return delegate.getPendingDeletions();
    }

    public ConcurrentHashMap<String, IndexInput> getIndexInputMap() {
        return indexInputMap;
    }

    public ConcurrentHashMap<String, IndexOutput> getIndexOutputMap() {
        return indexOutputMap;
    }

    public void hijack(String file) {
        try {
            System.out.println(">>> Hijack file: " + file);
            Field field = delegate.getClass().getDeclaredField("files");
            field.setAccessible(true);
            ConcurrentHashMap<String, Object> files = (ConcurrentHashMap) field.get(delegate);
            Object o = files.get(file);
            Field contentField = o.getClass().getDeclaredField("content");
            contentField.setAccessible(true);
            IndexInput indexInput = (IndexInput) contentField.get(o);
            System.out.println(indexInput);
            Field inField = indexInput.getClass().getDeclaredField("in");
            inField.setAccessible(true);
            ByteBuffersDataInput bbdi = (ByteBuffersDataInput)inField.get(indexInput);
            Field blocks = bbdi.getClass().getDeclaredField("blocks");
            blocks.setAccessible(true);
            ByteBuffer[] bba = (ByteBuffer[])blocks.get(bbdi);
            System.out.println(bba.getClass());
            System.out.println(indexInput.readString());
        } catch (EOFException ee) {
            System.out.println("already close " + file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
