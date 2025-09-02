
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    private static final String GLUSTER_MOUNT_POINT = "/mnt/gluster";
    private static final String TEST_DIR = GLUSTER_MOUNT_POINT + "/java-app-test";
    
    public static void main(String[] args) {
        System.out.println("=== Java 21 GlusterFS Integration Demo ===");
        
        try {
            checkGlusterFSMount();
            createTestDirectory();
            performFileOperations();
            listGlusterFSContents();
            testConcurrentOperations();
            
            System.out.println("\n=== GlusterFS App Completed Successfully! ===");
            
        } catch (Exception e) {
            System.err.println("Error during GlusterFS operations: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void checkGlusterFSMount() throws IOException {
        Path mountPath = Paths.get(GLUSTER_MOUNT_POINT);
        
        if (!Files.exists(mountPath)) {
            throw new IOException("GlusterFS mount point does not exist: " + GLUSTER_MOUNT_POINT);
        }
        
        if (!Files.isDirectory(mountPath)) {
            throw new IOException("GlusterFS mount point is not a directory: " + GLUSTER_MOUNT_POINT);
        }
        
        try {
            Path testFile = mountPath.resolve(".write-test");
            Files.write(testFile, "test".getBytes());
            Files.delete(testFile);
            System.out.println("✓ GlusterFS mount point is accessible and writable");
        } catch (IOException e) {
            throw new IOException("GlusterFS mount point is not writable: " + e.getMessage());
        }
    }
    
    private static void createTestDirectory() throws IOException {
        Path testDir = Paths.get(TEST_DIR);
        Files.createDirectories(testDir);
        System.out.println("✓ Created test directory: " + TEST_DIR);
    }
    
    private static void performFileOperations() throws IOException {
        System.out.println("\n--- File Operations Test ---");
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String fileName = "test-file-" + timestamp + ".txt";
        Path filePath = Paths.get(TEST_DIR, fileName);
        
        List<String> content = List.of(
            "GlusterFS Test File",
            "Created at: " + LocalDateTime.now(),
            "Java Version: " + System.getProperty("java.version"),
            "Container ID: " + System.getenv("HOSTNAME"),
            "This file is stored in a distributed GlusterFS volume!"
        );
        
        Files.write(filePath, content);
        System.out.println("✓ Written file: " + fileName);
        
        List<String> readContent = Files.readAllLines(filePath);
        System.out.println("✓ Read file content (" + readContent.size() + " lines):");
        readContent.forEach(line -> System.out.println("  " + line));
        
        long fileSize = Files.size(filePath);
        System.out.println("✓ File size: " + fileSize + " bytes");
    }
    
    private static void listGlusterFSContents() throws IOException {
        System.out.println("\n--- GlusterFS Contents ---");
        
        System.out.println("Root directory contents:");
        try (var stream = Files.list(Paths.get(GLUSTER_MOUNT_POINT))) {
            stream.forEach(path -> {
                try {
                    String type = Files.isDirectory(path) ? "[DIR]" : "[FILE]";
                    long size = Files.isDirectory(path) ? 0 : Files.size(path);
                    System.out.println("  " + type + " " + path.getFileName() + " (" + size + " bytes)");
                } catch (IOException e) {
                    System.out.println("  [?] " + path.getFileName() + " (error reading attributes)");
                }
            });
        }
        
        System.out.println("\nTest directory contents:");
        try (var stream = Files.list(Paths.get(TEST_DIR))) {
            stream.forEach(path -> {
                try {
                    String type = Files.isDirectory(path) ? "[DIR]" : "[FILE]";
                    long size = Files.isDirectory(path) ? 0 : Files.size(path);
                    System.out.println("  " + type + " " + path.getFileName() + " (" + size + " bytes)");
                } catch (IOException e) {
                    System.out.println("  [?] " + path.getFileName() + " (error reading attributes)");
                }
            });
        }
    }
    
    private static void testConcurrentOperations() throws IOException, InterruptedException {
        System.out.println("\n--- Concurrent Operations Test ---");
        
        List<Thread> threads = new ArrayList<>();
        int numThreads = 5;
        
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            Thread thread = new Thread(() -> {
                try {
                    String fileName = "concurrent-test-thread-" + threadId + ".txt";
                    Path filePath = Paths.get(TEST_DIR, fileName);
                    
                    List<String> content = List.of(
                        "Thread ID: " + threadId,
                        "Timestamp: " + LocalDateTime.now(),
                        "Random data: " + Math.random()
                    );
                    
                    Files.write(filePath, content);
                    
                    List<String> readBack = Files.readAllLines(filePath);
                    System.out.println("✓ Thread " + threadId + " completed file operations");
                    
                } catch (IOException e) {
                    System.err.println("✗ Thread " + threadId + " failed: " + e.getMessage());
                }
            });
            
            threads.add(thread);
            thread.start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("✓ All concurrent operations completed");
    }
}
