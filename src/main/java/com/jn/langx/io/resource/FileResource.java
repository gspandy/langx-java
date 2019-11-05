package com.jn.langx.io.resource;

import com.jn.langx.annotation.NonNull;
import com.jn.langx.util.Preconditions;
import com.jn.langx.util.io.file.Filenames;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * file:/home/fjn/xx/yy
 */
public class FileResource extends AbstractPathableResource<File> implements Urlable {
    private File file;
    public static final String PATTERN = "file:";
    public static final String FILE_URL_PATTERN = "file://";

    private String cleanedPath;

    public FileResource(@NonNull String path) {
        Preconditions.checkTrue(path.startsWith(PATTERN) && !path.startsWith(FILE_URL_PATTERN));
        setPath(path);
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
        cleanedPath = path.substring(PATTERN.length());
        cleanedPath = Filenames.cleanPath(cleanedPath);
        file = new File(cleanedPath);
    }

    @Override
    public URL getUrl() {
        if (exists()) {
            try {
                return file.toURL();
            } catch (MalformedURLException ex) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String getAbsolutePath() {
        return exists() ? file.getAbsolutePath() : null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    @Override
    public boolean isReadable() {
        return exists() && file.canRead();
    }


    @Override
    public boolean exists() {
        return file != null && file.exists();
    }

    @Override
    public File getRealResource() {
        return file;
    }

    @Override
    public long contentLength() {
        return exists() ? file.length() : -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileResource)) {
            return false;
        }
        FileResource o2 = (FileResource) obj;
        return this.cleanedPath.equals(o2.cleanedPath);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}