import org.apache.lucene.store.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EnhancedDirectory extends BaseDirectory {

    private ByteBuffersDirectory delegate = new ByteBuffersDirectory();
    private ConcurrentHashMap<String,IndexInput> indexInputMap = new ConcurrentHashMap<String,IndexInput>();
    private ConcurrentHashMap<String,IndexOutput> indexOutputMap = new ConcurrentHashMap<String,IndexOutput>();

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
        IndexOutput result = delegate.createOutput(name,context);
        indexOutputMap.put(name,result);
        return result;
    }

    @Override
    public IndexOutput createTempOutput(String prefix, String suffix, IOContext context) throws IOException {
        IndexOutput result = delegate.createTempOutput(prefix,suffix,context);
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
        delegate.rename(source,dest);
    }

    @Override
    public IndexInput openInput(String name, IOContext context) throws IOException {
        IndexInput result = delegate.openInput(name,context);
        indexInputMap.put(name,result);
        System.out.println("Opening : " + result.toString());
        try {
            readDataPrint(this,name,0,(int)fileLength(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private static void readDataPrint(Directory memoryIndex,String file,long pointer,int len) throws Exception {
        byte[] buffer = new byte[len];
        IndexInput indexInput = ((EnhancedDirectory)memoryIndex).getIndexInputMap().get(file);
        if (indexInput!=null){
            indexInput.readBytes(buffer,0,len);
            System.out.println(new String(buffer, StandardCharsets.UTF_8));
            indexInput.seek(0);
        }else{
            System.out.println("dont have this file yet: " + file);
        }
    }

}
